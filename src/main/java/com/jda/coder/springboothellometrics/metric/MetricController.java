package com.jda.coder.springboothellometrics.metric;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MetricController implements MetricAPI {

    private final MetricService metricService;

    @Override
    public Metric getStatus() {
        log.info("Status endpoint called via MetricAPI interface");
        return metricService.getMetrics();
    }
}
