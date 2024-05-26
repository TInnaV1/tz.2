package org.example;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Program {
    public static ArrayList<BigInteger> readFile(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String line = bufferedReader.readLine();
        bufferedReader.close();

        StringTokenizer tokenizer = new StringTokenizer(line);
        ArrayList<BigInteger> result = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            result.add(new BigInteger(tokenizer.nextToken()));
        }
        return result;
    }

    public static BigInteger min(ArrayList<BigInteger> dataInt) {
        BigInteger min = dataInt.get(0);
        for (int i = 1; i < dataInt.size(); i++) {
            if (dataInt.get(i).compareTo(min) < 0) min = dataInt.get(i);
        }
        return min;
    }

    public static BigInteger max(ArrayList<BigInteger> dataInt) {
        BigInteger max = dataInt.get(0);
        for (int i = 1; i < dataInt.size(); i++) {
            if (dataInt.get(i).compareTo(max) > 0) max = dataInt.get(i);
        }
        return max;
    }

    public static BigInteger sum(ArrayList<BigInteger> dataInt) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger num : dataInt) {
            sum = sum.add(num);
        }
        return sum;
    }

    public static BigInteger mult(ArrayList<BigInteger> dataInt) {
        BigInteger mult = BigInteger.ONE;
        for (BigInteger num : dataInt) {
            mult = mult.multiply(num);
        }
        return mult;
    }
}
