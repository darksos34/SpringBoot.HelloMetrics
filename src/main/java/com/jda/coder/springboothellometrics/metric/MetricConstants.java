package com.jda.coder.springboothellometrics.metric;

public final class MetricConstants {

    // Prevent instantiation of this utility class
    private MetricConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // --- API Endpoints ---
    public static final String API_METRICS_BASE_URL = "/api/metrics";
    public static final String ENDPOINT_STATUS = "/status";

    // --- Default Values ---
    public static final String DEFAULT_UNKNOWN_DEVICE = "Unknown Device";
    public static final String STATUS_OK = "OK";
}
