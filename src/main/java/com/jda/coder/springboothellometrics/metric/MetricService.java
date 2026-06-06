package com.jda.coder.springboothellometrics.metric;

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

        return new Metric(deviceName, cpuUsage, MetricConstants.STATUS_OK);
    }

    // --- Helper Methods to keep logic clean ---

    private String getComputerName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            log.warn("Unable to resolve hostname");
            return MetricConstants.DEFAULT_UNKNOWN_DEVICE;
        }
    }

    private String getCpuUsagePercentage() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        double load = osBean.getCpuLoad();
        double percentage = Math.max(load * 100, 0.0);

        return String.format("%.2f%%", percentage);
    }
}
