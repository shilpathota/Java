package com.techiebees;

import java.util.Base64;

public class base64encodedecode {
    public static void executeencodedecode() {
        // Getting encoder
        Base64.Encoder encoder = Base64.getEncoder();
        // Creating byte array
        byte byteArr[] = {1,2};
        // encoding byte array
        byte byteArr2[] = encoder.encode(byteArr);
        System.out.println("Encoded byte array: "+byteArr2);
        byte byteArr3[] = new byte[5];                // Make sure it has enough size to store copied bytes
        int x = encoder.encode(byteArr,byteArr3);    // Returns number of bytes written
        System.out.println("Encoded byte array written to another array: "+byteArr3);
        System.out.println("Number of bytes written: "+x);

        // Encoding string
        String str = encoder.encodeToString("mystring".getBytes());
        System.out.println("Encoded string: "+str);
        // Getting decoder
        Base64.Decoder decoder = Base64.getDecoder();
        // Decoding string
        String dStr = new String(decoder.decode(str));
        System.out.println("Decoded string: "+dStr);


        //URL encoding and decoding
        // Getting encoder
        Base64.Encoder encoder2 = Base64.getUrlEncoder();
        // Encoding URL
        String eStr2 = encoder2.encodeToString("This is a good learning".getBytes());
        System.out.println("Encoded URL: "+eStr2);
        // Getting decoder
        Base64.Decoder decoder2 = Base64.getUrlDecoder();
        // Decoding URl
        String dStr2 = new String(decoder2.decode(eStr2));
        System.out.println("Decoded URL: "+dStr2);

        // Getting MIME encoder
        Base64.Encoder encoder3 = Base64.getMimeEncoder();
        String message = "Hello, \nYou are informed regarding your inconsistency of work";
        String eStr3 = encoder3.encodeToString(message.getBytes());
        System.out.println("Encoded MIME message: "+eStr3);

        // Getting MIME decoder
        Base64.Decoder decoder3 = Base64.getMimeDecoder();
        // Decoding MIME encoded message
        String dStr3 = new String(decoder3.decode(eStr3));
        System.out.println("Decoded message: "+dStr3);
    }
}
