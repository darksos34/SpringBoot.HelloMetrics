package com.jda.coder.springboothellometrics.metric;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates Getters, Setters, toString, etc.
@AllArgsConstructor // Generates a constructor with all arguments
@NoArgsConstructor  // Generates an empty constructor
@Builder
public class Metric {

    private String name;
    private String cpu;  // lowercase 'c' is the Java standard
    private String pods; // lowercase 'p' is the Java standard


}
