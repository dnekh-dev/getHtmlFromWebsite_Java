package com.dnekh;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {

    public static void main(String[] args) {

        try {
            URL website = new URL("https://google.com");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream file = new FileOutputStream("data.html");
            file.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (IOException ex) {
            System.out.println("Something goes wrong:(");
            ex.printStackTrace();
        }

    }
}
