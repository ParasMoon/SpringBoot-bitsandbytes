package com.bitsandbytes.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyApppConfig {
    @Bean
    public MyComponent myComponent() {
          return new MyComponent();
    }


}
