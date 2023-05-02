
package com.JulietaNothoff.Portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author julie
 */

@Entity
public class Hys {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int html;
    private int bootstrap;
    private int angular;
    private int mysql;
    private int java;
    private int springboot;

    public Hys() {
    }

    public Hys(int html, int bootstrap, int angular, int mysql, int java, int springboot) {
        this.html = html;
        this.bootstrap = bootstrap;
        this.angular = angular;
        this.mysql = mysql;
        this.java = java;
        this.springboot = springboot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
