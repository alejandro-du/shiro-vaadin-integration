package org.vaadin.shiro;

import org.apache.shiro.web.servlet.ShiroFilter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

public class VaadinShiroFilter extends ShiroFilter {

    @Override
    protected ServletRequest wrapServletRequest(HttpServletRequest orig) {
        String body = "";

        try {
            body = orig.getReader().lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new CustomBodyHttpServletRequestWrapper((HttpServletRequest) super.wrapServletRequest(orig), body);
    }

}
