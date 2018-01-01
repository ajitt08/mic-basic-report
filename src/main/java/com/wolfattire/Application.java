package com.wolfattire;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.wolfattire.config.AppSecurityConfig;
import com.wolfattire.config.AppWebMvcConfig;

@Import({AppWebMvcConfig.class, AppSecurityConfig.class})
@ComponentScan(basePackages = {"com.wolfattire.*"})
public class Application {

}
