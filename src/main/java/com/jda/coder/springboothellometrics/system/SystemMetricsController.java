package com.jda.coder.springboothellometrics.system;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/system")
public class SystemMetricsController {

    private final SystemMetricService systemMetricService;

    @GetMapping("/increment")
    public String incrementCounter() {
        log.info("Counter increment endpoint called");
        systemMetricService.incrementCounter();
        return "Counter incremented";
    }

    @GetMapping("/gauge/up")
    public String increaseGauge() {
        log.info("Gauge increased");
        systemMetricService.increaseGauge();
        return "Gauge increased";
    }

    @GetMapping("/gauge/down")
    public String decreaseGauge() {
        log.info("Gauge decreased");
        systemMetricService.decreaseGauge();
        return "Gauge decreased";
    }
}
