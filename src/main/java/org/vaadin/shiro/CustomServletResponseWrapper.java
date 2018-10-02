package org.vaadin.shiro;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class CustomServletResponseWrapper extends HttpServletResponseWrapper {

    private final StringWriter master = new StringWriter();
    private final StringWriter branch = new StringWriter();

    public CustomServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(master);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new StringBasedServletOutputStream(master, branch);
    }


    public StringWriter getMaster() {
        return master;
    }

    public StringWriter getBranch() {
        return branch;
    }

}
