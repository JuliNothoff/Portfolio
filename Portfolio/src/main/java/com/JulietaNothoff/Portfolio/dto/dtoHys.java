
package com.JulietaNothoff.Portfolio.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author julie
 */
public class dtoHys {
    
    @NotBlank
    private int html;
    @NotBlank
    private int bootstrap;
    @NotBlank
    private int angular;
    @NotBlank
    private int mysql;
    @NotBlank
    private int java;
    @NotBlank
    private int springboot;

    public dtoHys() {
    }

    public dtoHys(int html, int bootstrap, int angular, int mysql, int java, int springboot) {
        this.html = html;
        this.bootstrap = bootstrap;
        this.angular = angular;
        this.mysql = mysql;
        this.java = java;
        this.springboot = springboot;
    }

    public int getHtml() {
        return html;
    }

    public void setHtml(int html) {
        this.html = html;
    }

    public int getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(int bootstrap) {
        this.bootstrap = bootstrap;
    }

    public int getAngular() {
        return angular;
    }

    public void setAngular(int angular) {
        this.angular = angular;
    }

    public int getMysql() {
        return mysql;
    }

    public void setMysql(int mysql) {
        this.mysql = mysql;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getSpringboot() {
        return springboot;
    }

    public void setSpringboot(int springboot) {
        this.springboot = springboot;
    }
    
    
    
}
