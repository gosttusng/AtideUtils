package com.atide.utils.net.webservice;

import org.repackage.ksoap2.transport.ServiceConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Lee on 14-4-16.
 */
public class WsServerConnectionSE implements ServiceConnection
{
    private HttpURLConnection connection;

    public WsServerConnectionSE(String url) throws IOException {
        this.connection = ((HttpURLConnection) new URL(url).openConnection());
        this.connection.setUseCaches(false);
        this.connection.setDoOutput(true);
        this.connection.setDoInput(true);
    }

    public void connect() throws IOException {
        this.connection.connect();
    }

    public void disconnect() {
        this.connection.disconnect();
    }

    public void setRequestProperty(String string, String soapAction) {
        this.connection.setRequestProperty(string, soapAction);
    }

    public void setRequestMethod(String requestMethod) throws IOException {
        this.connection.setRequestMethod(requestMethod);
    }

    public OutputStream openOutputStream() throws IOException {
        return this.connection.getOutputStream();
    }

    public InputStream openInputStream() throws IOException {
        return this.connection.getInputStream();
    }

    public InputStream getErrorStream() {
        return this.connection.getErrorStream();
    }

    // 设置连接服务器的超时时间,毫秒级,此为自己添加的方法
    public void setConnectionTimeOut(int timeout) {
        this.connection.setConnectTimeout(timeout);
    }
}
