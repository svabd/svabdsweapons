package net.sv_abd.svabdsweapons.shader;

public class ShaderTimeTracker {
    // Record the system time when the game/mod initializes
    private static final long START_TIME = System.currentTimeMillis();

    public static float getTimeSinceStart() {
        return (System.currentTimeMillis() - START_TIME) / 1000.0f; // Return in seconds
    }
}
