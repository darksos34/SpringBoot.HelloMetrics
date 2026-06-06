package com.jda.coder.springboothellometrics.metric;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(MetricConstants.API_METRICS_BASE_URL)
public interface MetricAPI {

    /**
     * Retrieves current CPU and system metrics.
     *
     * @return A Metric object containing the hardware data.
     */
    @GetMapping(MetricConstants.ENDPOINT_STATUS)
    Metric getStatus();

}
