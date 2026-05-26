package bep.hax;

import bep.hax.commands.Center;
import bep.hax.commands.Coordinates;
import bep.hax.hud.*;
import bep.hax.managers.PacketManager;
import bep.hax.modules.*;
import bep.hax.modules.highwayborers.*;
import bep.hax.modules.highwayborers.BorerModule.*;
import bep.hax.modules.hud.TextPresets.*;
import bep.hax.modules.searcharea.SearchArea;
import bep.hax.system.HIGTab.*;
import bep.hax.util.*;
import bep.hax.util.StardustUtil;
import com.jcraft.jogg.Page;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.gui.tabs.Tabs;
import meteordevelopment.meteorclient.systems.Systems;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.misc.BetterChat;
import meteordevelopment.meteorclient.utils.Utils;
import meteordevelopment.meteorclient.utils.misc.MeteorStarscript;
import meteordevelopment.orbit.EventHandler;
import meteordevelopment.orbit.EventPriority;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.enchantment.effect.entity.SpawnParticlesEnchantmentEffect.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.s2c.play.OverlayMessageS2CPacket;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

import java.awt.print.Book;

import static meteordevelopment.meteorclient.MeteorClient.mc;


public class Bep extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Bephax");
    public static final Category STASH = new Category("Stash Hunt");
    public static final Category BORERS= new Category("Bobers");
    public static final Category TST= new Category("TrouserStreak");
    public static final Category IKEA= new Category("IKEA");
    public static final Category STARDUST= new Category("Stardust");
    public static final Category METEORIST= new Category("Meteorist");
    public static final Category REJECTS= new Category("Meteor Rejects");
    public static final Category HIG = new Category("HIG Tools");
    public static final HudGroup HUD_GROUP = new HudGroup("Bephax");

    @Override
    public void onInitialize() {
        LOG.info("BEPHAX LOADING.");
        new CoordPoster();

        Modules.get().add(new AutoSmithing());
        Modules.get().add(new BepMine());
        Modules.get().add(new GrimSilentRotations());
        Modules.get().add(new YawLock());
        Modules.get().add(new UnfocusedFpsLimiter());


        // JEFF STASH HUNTING https://github.com/miles352/meteor-stashhunting-addon
        Modules.get().add(new ElytraFlyPlusPlus());
        Modules.get().add(new AFKVanillaFly());
        Modules.get().add(new NoJumpDelay());
        Modules.get().add(new AutoEXPPlus());
        Modules.get().add(new AutoLogPlus());
        Modules.get().add(new AutoPortal());
        Modules.get().add(new ChestIndex());
        Modules.get().add(new GotoPosition());
        Modules.get().add(new HighlightOldLava());
        Modules.get().add(new Pitch40Util());
        Modules.get().add(new GrimAirPlace());
        Modules.get().add(new TrailFollower());
        Modules.get().add(new VanityESP());
        Modules.get().add(new BetterStashFinder());
        Modules.get().add(new OldChunkNotifier());
        Modules.get().add(new SearchArea());

        // HIGTools https://github.com/RedCarlos26/HIGTools
        Modules.get().add(new AfkLogout());
        Modules.get().add(new AutoCenter());
        Modules.get().add(new AutoWalkHIG());
        Modules.get().add(new AxisViewer());
        Modules.get().add(new HighwayBuilderHIG());
        Modules.get().add(new HighwayTools());
        Modules.get().add(new HotbarManager());
        Modules.get().add(new LiquidFillerHIG());
        Modules.get().add(new OffhandManager());
        Modules.get().add(new ScaffoldHIG());
        Commands.add(new bep.hax.commands.Coordinates());

        // Borers
        Modules.get().add(new AxisBorer());
        Modules.get().add(new NegNegBorer());
        Modules.get().add(new NegPosBorer());
        Modules.get().add(new PosNegBorer());
        Modules.get().add(new PosPosBorer());

        // TrouserStreak https://github.com/etianl/Trouser-Streak
        Modules.get().add(new BetterScaffold());
        Modules.get().add(new SuperInstaMine());
        Modules.get().add(new BetterAutoSign());

        // IKEA https://github.com/Nooniboi/Public-Ikea
        Modules.get().add(new AntiInteract());
        Modules.get().add(new AutoItemMove());
        Modules.get().add(new AntiDrop());
        Modules.get().add(new DubCounter());

        // Meteor Rejects https://github.com/AntiCope
        Modules.get().add(new AutoCraft());
        Modules.get().add(new VehicleOneHit());

        // Stardust https://github.com/0xTas/stardust
        Commands.add(new bep.hax.commands.FirstSeen2b2t());
        Commands.add(new bep.hax.commands.LastSeen2b2t());
        Commands.add(new bep.hax.commands.Playtime2b2t());
        Commands.add(new bep.hax.commands.Stats2b2t());
        Commands.add(new bep.hax.commands.Panorama());
        Commands.add(new bep.hax.commands.Loadout());

        // Stardust Modules https://github.com/0xTas/stardust
        Modules.get().add(new Loadouts());
        Modules.get().add(new AntiToS());
        Modules.get().add(new ChatSigns());
        Modules.get().add(new Archaeology());
        Modules.get().add(new AutoDoors());
        Modules.get().add(new AutoDrawDistance());
        Modules.get().add(new AutoDyeShulkers());
        Modules.get().add(new AxolotlTools());
        Modules.get().add(new BannerData());
        Modules.get().add(new BookTools());
        Modules.get().add(new Honker());
        Modules.get().add(new LoreLocator());
        Modules.get().add(new MusicTweaks());
        Modules.get().add(new PagePirate());
        Modules.get().add(new RapidFire());
        Modules.get().add(new RoadTrip());
        Modules.get().add(new RocketJump());
        Modules.get().add(new RocketMan());
        Modules.get().add(new SignHistorian());
        Modules.get().add(new SignatureSign());
        Modules.get().add(new StashBrander());
        Modules.get().add(new WaxAura());
        Modules.get().add(new TreasureESP());
        Modules.get().add(new Updraft());

        // Meteorist https://github.com/Zgoly/Meteorist/
        Modules.get().add(new DisconnectSound());
        // HUD
        Hud.get().register(BlockCounterHud.INFO);

    }


    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
        Modules.registerCategory(STASH);
        Modules.registerCategory(BORERS);
        Modules.registerCategory(TST);
        Modules.registerCategory(IKEA);
        Modules.registerCategory(STARDUST);
        Modules.registerCategory(METEORIST);
        Modules.registerCategory(REJECTS);
        Modules.registerCategory(HIG);
    }

    @Override
    public String getPackage() {
        return "bep.hax";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("BepHax", "bephax");
    }
}
