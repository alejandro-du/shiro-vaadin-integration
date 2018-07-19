package org.vaadin.shiro.demo;

import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.vaadin.shiro.VaadinShiroFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;

public class WebConfig {

    @WebListener
    public static class ShiroListener extends EnvironmentLoaderListener {
    }

    @WebFilter(urlPatterns = "/*")
    public static class ShiroFilter extends VaadinShiroFilter {
    }

}
