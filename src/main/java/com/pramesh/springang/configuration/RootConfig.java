/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.springang.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.pramesh.springang.init.DataInit;

/**
 *
 * @author prames
 */
@Configuration
@Import(DataSourceConfig.class)
@ComponentScan({"com.pramesh.springang.service", "com.pramesh.springang.init"})
public class RootConfig {
    
    @Bean(initMethod = "init")
    public DataInit initData() {
        return new DataInit();
    }
}