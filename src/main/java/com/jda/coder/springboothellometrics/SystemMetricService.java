package com.jda.coder.springboothellometrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SystemMetricService {

    private int activeUsers = 0;
    private final Counter requestCounter;

    public SystemMetricService(MeterRegistry registry) {
        // Registering a Gauge directly to the method
        registry.gauge("custom.gauge.value", this, SystemMetricService::getActiveUsers);

        // Register and store the Counter so we don't have to fetch it repeatedly
        this.requestCounter = registry.counter("custom.counter.total", "type", "simple");

        log.info("Micrometer metrics successfully registered");
    }

    // --- Actions ---

    public void incrementCounter() {
        this.requestCounter.increment();
        log.debug("Counter 'custom.counter.total' incremented");
    }

    public void increaseGauge() {
        this.activeUsers++;
        log.debug("Active users gauge increased to {}", this.activeUsers);
    }

    public void decreaseGauge() {
        this.activeUsers--;
        log.debug("Active users gauge decreased to {}", this.activeUsers);
    }

    // --- Micrometer asks this method for the Gauge data ---

    private int getActiveUsers() {
        return activeUsers;
    }
}
