package com.asuna.launcher.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Eleria on 07/01/2017.
 */
public class Downloader {

    private final static Logger LOGGER = Logger.getLogger(Downloader.class.getName());
    public static void download(URL url, File file)
    {
        LOGGER.log(Level.INFO, "Starting Download of: " + url);
        try {
            FileUtils.copyURLToFile(url, file);
        }
        catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Failed Downloading " + url);
        }
    }
}
