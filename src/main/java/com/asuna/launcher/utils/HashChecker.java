package com.asuna.launcher.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Eleria on 07/01/2017.
 */
public class HashChecker {

    public static String checkHash(File file) throws IOException{
        Logger LOGGER = Logger.getLogger(HashChecker.class.getName());
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-512");
        }
        catch (NoSuchAlgorithmException ex)
        {
            LOGGER.log(Level.SEVERE, "Couldnt Find SHA-512 Alg");
            throw new IOException("");
        }

        //Reading File Content
        FileInputStream fizz = new FileInputStream(file);

        //BYTE ARRAYS \o/
        byte[] byteArray = new byte[1024];
        int bytesCount;

        //File Reader
        while ((bytesCount = fizz.read(byteArray)) != -1){
            digest.update(byteArray, 0, bytesCount);
        }
        fizz.close();
        //Get Hash Bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String string;
        string = sb.toString();
        //return complete hash
        return string;

    }
}
