package com.example.secondpro.mynewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    // helloo123
    ///HHHH
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            String strContent = "Hello world!";

            URL url = new URL("www.baidu.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);

            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(strContent.length()));
            httpURLConnection.setRequestProperty("Accept", "application/json");

            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(strContent.getBytes("utf-8"));
            outputStream.flush();
            outputStream.close();

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte byteData[] = new byte[1024];
                int nLen = 0;
                while ((nLen = inputStream.read(byteData)) != -1) {
                    byteArrayOutputStream.write(byteData, 0, nLen);
                }
                byte byte2[] = byteArrayOutputStream.toByteArray();
                String strJSON = new String(byte2);

                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // hello world
    }
}
