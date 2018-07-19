package org.vaadin.shiro;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomBodyHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private String body;

    public CustomBodyHttpServletRequestWrapper(HttpServletRequest request, String body) {
        super(request);
        this.body = body;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream(), "UTF-8"));
    }

    @Override
    public ServletInputStream getInputStream() {
        return new StringBasedServletInputStream(body);
    }

}
