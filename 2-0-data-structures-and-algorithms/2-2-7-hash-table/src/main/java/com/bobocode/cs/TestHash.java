package com.bobocode.cs;

public class TestHash {

    /**
     * <a href="https://www.youtube.com/watch?v=RIyz2_0FTbE">...</a>
     */
    public static int test() {

        String key = "test";
        int capacity = 8;

        var hash = key.hashCode() ^ (key.hashCode() >> 16);
        System.out.println("Hash: " + hash);
        //Hash: = 3556516

        System.out.println(">> 16: " + (hash >> 16));
        // 3556516 >> 16 = 54
        //      2^16 = 65536
        //      3556516 / 65536 = 54,268127441 = 54



        int xor = hash ^ 54;
        System.out.println("XOR: " + xor);
        // ^ - XOR - 3556498
        // якщо в обох операндів 1 то буде 0
        // якщо в обох операндыв 0 то буде 1


        System.out.println("xor binary: " + Integer.toBinaryString(xor));
        System.out.println("capacity binary: " + Integer.toBinaryString((capacity - 1)));
        System.out.println("& binary : " + (Integer.toBinaryString(54 & capacity-1)));
        System.out.println("&: " + (xor & capacity-1));
        // Hash binary: 1101100100010010010010 -> 010
        // capacity binary: 111
        // & binary : 110  - операнд залишаэться сталим тільки в тому випадку якщо в обидва операнди одинакові (? в іншому випадку замінється протележним)
        // &: 6


        int result =  xor & (capacity-1);

        System.out.println("result: " + result);

        return result;
    }
}
