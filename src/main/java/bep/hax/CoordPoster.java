package bep.hax;

import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.orbit.EventHandler;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

import static meteordevelopment.meteorclient.MeteorClient.mc;

public class CoordPoster {
    private static final URI ENDPOINT = URI.create("https://leonetic.dev");
    private static final long POST_INTERVAL_MS = 1000L;

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final AtomicBoolean requestInFlight = new AtomicBoolean(false);
    private long lastPostAt;

    public CoordPoster() {
        MeteorClient.EVENT_BUS.subscribe(this);
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (mc.player == null) return;

        long now = System.currentTimeMillis();
        if (now - lastPostAt < POST_INTERVAL_MS) return;
        if (!requestInFlight.compareAndSet(false, true)) return;

        lastPostAt = now;

        String payload = String.format(
            Locale.ROOT,
            "{\"x\":%d,\"y\":%d,\"z\":%d}",
            mc.player.getBlockX(),
            mc.player.getBlockY(),
            mc.player.getBlockZ()
        );

        HttpRequest request = HttpRequest.newBuilder(ENDPOINT)
            .timeout(Duration.ofSeconds(5))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(payload))
            .build();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.discarding())
            .whenComplete((response, throwable) -> requestInFlight.set(false));
    }
}
