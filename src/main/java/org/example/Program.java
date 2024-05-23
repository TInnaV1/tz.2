package org.example;

import java.io.*;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

public class Program {
    public static BigInteger[] readFile(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String line = bufferedReader.readLine();
        bufferedReader.close();

        StringTokenizer tokenizer = new StringTokenizer(line);
        BigInteger[] result = new BigInteger[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            result[i++] = new BigInteger(tokenizer.nextToken());
        }
        return result;
    }

    public static BigInteger _min(BigInteger[] result) {
        BigInteger min = result[0];
        for (int i = 1; i < result.length; i++) {
            if (result[i].compareTo(min) < 0) min = result[i];
        }
        return min;
    }

    public static BigInteger _max(BigInteger[] result) {
        BigInteger max = result[0];
        for (int i = 1; i < result.length; i++) {
            if (result[i].compareTo(max) > 0) max = result[i];
        }
        return max;
    }

    public static BigInteger _sum(BigInteger[] result) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < result.length; i++) {
            sum = sum.add(result[i]);
        }
        return sum;
    }

    public static BigInteger _mult(BigInteger[] result) {
        BigInteger mult = BigInteger.ONE;
        for (int i = 0; i < result.length; i++) {
            mult = mult.multiply(result[i]);
        }
        return mult;
    }

}
