package com.jda.coder.springboothellometrics;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/metrics")
public class MetricController {

    private final MetricService metricService;

    @GetMapping("/status")
    public Metric getStatus() {
        log.info("Status endpoint called");
        return metricService.getMetrics();
    }
}
