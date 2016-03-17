package edu.rosehulman.pokerbot;

import java.util.List;

/**
 * Created by a on 3/15/16.
 */
public class CactusKev {

    static double handStrength(String[] ourcards) {
        int ahead = 0;
        int tied = 0;
        int behind = 0;
        int ourrank = rank(ourcards[0],ourcards[1],ourcards[2],ourcards[3],ourcards[4]);
        return (ourrank * 1.0) / 7500.0;
    }

    static int rank(String s1, String s2, String s3, String s4, String s5) {
        int c1 = encode(s1);
        int c2 = encode(s2);
        int c3 = encode(s3);
        int c4 = encode(s4);
        int c5 = encode(s5);

        int flushVal = isFlush(c1, c2, c3, c4, c5);
        if (flushVal != 0) {

            return flushVal;
        } else {
            int q = (c1 | c2 | c3 | c4 | c5) >> 16;
            short straightOrHighVal = Tables.unique5[q];
            if (straightOrHighVal != 0) {
                return straightOrHighVal;
            } else {
                System.out.println(Integer.toBinaryString(c1));
                System.out.println(Integer.toBinaryString(c2));
                System.out.println(Integer.toBinaryString(c3));
                System.out.println(Integer.toBinaryString(c4));
                System.out.println(Integer.toBinaryString(c5));
                int x = (c1 & 0x00FF) * (c2 & 0x00FF) * (c3 & 0x00FF) * (c4 & 0x00FF) * (c5 & 0xFF);
                System.out.println(x);
                int val = Tables.products[x];
                System.out.println("A");
                return val;
            }
        }
    }

    static int isFlush(int c1, int c2, int c3, int c4, int c5) {
        if ((c1 & c2 & c3 & c4 & c5 & 0xF000) != 0) {
            int q = (c1 | c2 | c3 | c4 | c5) >> 16;
            return Tables.flushes[q];
        } else {
            return 0;
        }
    }


    static int encode(String card) {
        char suit = card.charAt(1);
        int number = 0;
        try {
            number = Integer.parseInt(card.substring(0, 1));
        } catch (NumberFormatException e) {
            if (card.substring(0, 1).equals("T")) {
                number = 10;
            } else if ((card.substring(0, 1).equals("J"))) {
                number = 11;
            } else if ((card.substring(0, 1).equals("Q"))) {
                number = 12;
            } else if ((card.substring(0, 1).equals("K"))) {
                number = 13;
            } else if ((card.substring(0, 1).equals("A"))) {
                number = 14;
            }
        }
        int val = 1 << (number - 2);
        //System.out.println(Integer.toBinaryString(val));
        if (suit == 'C') {
            val = (val << 4) | 8;
        } else if (suit == 'D') {
            val = (val << 4) | 4;
        } else if (suit == 'H') {
            val = (val << 4) | 2;
        } else if (suit == 'S') {
            val = (val << 4) | 1;
        }

        //System.out.println(Integer.toBinaryString(val));

        val = (val << 4) | (number - 2);

        //System.out.println(Integer.toBinaryString(val));
        val <<= 2;

        //System.out.println(Integer.toBinaryString(val));
        val = (val << 6) | Tables.primes[number - 2];

//        System.out.println(Integer.toBinaryString(val));

        return val;

    }
}
