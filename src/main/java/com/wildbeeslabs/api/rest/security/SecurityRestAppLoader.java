/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wildbeeslabs.api.rest.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Initial Security REST Application class loader
 *
 * @author Alex
 * @version 1.0.0
 * @since 2017-08-08
 */
@SpringBootApplication(scanBasePackages = {"com.wildbeeslabs.api.rest.security", "com.wildbeeslabs.api.rest.common"})
//@ComponentScan({"com.wildbeeslabs.rest", "com.wildbeeslabs.api.rest.common"})
//@Import({JpaConfiguration.class, SecurityConfiguration.class, AppConfiguration.class, WebConfiguration.class, ValidatorConfiguration.class})
public class SecurityRestAppLoader {

    public static void main(String[] args) {
        SpringApplication.run(SecurityRestAppLoader.class, args);
    }
}
