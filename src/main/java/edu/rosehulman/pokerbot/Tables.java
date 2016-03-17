package edu.rosehulman.pokerbot;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Tables {
    static short flushes[];
    static {
        try {
            String file = new Scanner(new File("src/main/resources/flushes")).useDelimiter("\\Z").next();
            String[] strings = file.split(",\\s*");
            flushes = new short[strings.length];
            for (int i = 0; i < strings.length; i++) {
                flushes[i] = Short.parseShort(strings[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*
    ** this is a table lookup for all non-flush hands consisting
    ** of five unique ranks (i.e.  either Straights or High Card
    ** hands).  it's similar to the above "flushes" array.
    */
    static short unique5[];
    static {
        try {
            String file = new Scanner(new File("src/main/resources/unique5")).useDelimiter("\\Z").next();
            String[] strings = file.split(",\\s*");
            unique5 = new short[strings.length];
            for (int i = 0; i < strings.length; i++) {
                unique5[i] = Short.parseShort(strings[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    static int products[];
    static {
        try {
            String file = new Scanner(new File("src/main/resources/products")).useDelimiter("\\Z").next();
            String[] strings = file.split(",\\s*");
            products = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                products[i] = Integer.parseInt(strings[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static short  values[];
    static {
        try {
            String file = new Scanner(new File("src/main/resources/values")).useDelimiter("\\Z").next();
            String[] strings = file.split(",\\s*");
            values = new short[strings.length];
            for (int i = 0; i < strings.length; i++) {
                values[i] = Short.parseShort(strings[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    ** each of the thirteen card ranks has its own prime number
    **
    ** deuce = 2
    ** trey  = 3
    ** four  = 5
    ** five  = 7
    ** ...
    ** king  = 37
    ** ace   = 41
    */
    static int primes[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41 };

    static int perm7[][] = new int[21][];
    static {
        perm7[0] = new int[]{ 0, 1, 2, 3, 4 };
        perm7[1] =   new int[]{ 0, 1, 2, 3, 5 };
        perm7[2] =        new int[]{ 0, 1, 2, 3, 6 };
        perm7[3] =new int[]{ 0, 1, 2, 4, 5 };
        perm7[4] =new int[]{ 0, 1, 2, 4, 6 };
        perm7[5] =new int[]{ 0, 1, 2, 5, 6 };
        perm7[6] =new int[]{ 0, 1, 3, 4, 5 };
        perm7[7] =new int[]{ 0, 1, 3, 4, 6 };
        perm7[8] =new int[]{ 0, 1, 3, 5, 6 };
        perm7[9] =new int[]{ 0, 1, 4, 5, 6 };
        perm7[10] =new int[]{ 0, 2, 3, 4, 5 };
        perm7[11] =new int[]{ 0, 2, 3, 4, 6 };
        perm7[12] =new int[]{ 0, 2, 3, 5, 6 };
                perm7[13] =new int[]{ 0, 2, 4, 5, 6 };
                perm7[14] =new int[]{ 0, 3, 4, 5, 6 };
                perm7[15] =new int[]{ 1, 2, 3, 4, 5 };
                perm7[16] =new int[]{ 1, 2, 3, 4, 6 };
                perm7[17] =new int[]{ 1, 2, 3, 5, 6 };
                perm7[18] =new int[]{ 1, 2, 4, 5, 6 };
                perm7[19] =new int[]{ 1, 3, 4, 5, 6 };
                perm7[20] =new int[]{ 2, 3, 4, 5, 6 };
    }


}
