package org.vaadin.shiro;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StringBasedServletInputStream extends ServletInputStream {

    private final InputStream sourceStream;
    private boolean finished = false;

    public StringBasedServletInputStream(String body) {
        sourceStream = new ByteArrayInputStream(body.getBytes());
    }

    @Override
    public int read() throws IOException {
        int data = sourceStream.read();
        if (data == -1) {
            finished = true;
        }
        return data;
    }

    @Override
    public int available() throws IOException {
        return sourceStream.available();
    }

    @Override
    public void close() throws IOException {
        super.close();
        sourceStream.close();
    }

    @Override
    public boolean isFinished() {
        return this.finished;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener readListener) {
        throw new UnsupportedOperationException();
    }

}
