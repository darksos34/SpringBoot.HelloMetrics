package com.jda.coder.springboothellometrics;

import com.sun.management.OperatingSystemMXBean; // MUST use com.sun instead of java.lang
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;

@Slf4j
@Service
public class MetricService {

    public Metric getMetrics() {
        log.debug("Collecting system metrics");

        String deviceName = getComputerName();
        String cpuUsage = getCpuUsagePercentage();

        log.debug("CPU usage: {}", cpuUsage);

        return new Metric(deviceName, cpuUsage, "OK");
    }

    // --- Helper Methods to keep logic clean ---

    private String getComputerName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            log.warn("Unable to resolve hostname");
            return "Unknown Device";
        }
    }

    private String getCpuUsagePercentage() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        // System load comes as a fraction (e.g. 0.45 = 45%)
        double load = osBean.getCpuLoad();

        // Ensure values below 0 reflect as 0.0
        double percentage = Math.max(load * 100, 0.0);

        return String.format("%.2f%%", percentage);
    }
}
