package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgramTest {

    @Test
    void minTest() {
        System.out.println("Test _min" + this);
        BigInteger[] numbers = {BigInteger.valueOf(2), BigInteger.valueOf(4), BigInteger.valueOf(6), BigInteger.valueOf(8), BigInteger.valueOf(10)};
        BigInteger exp = BigInteger.valueOf(2);
        BigInteger res = Program._min(numbers);
        assertEquals(exp, res);
    }

    @Test
    void maxTest() {
        System.out.println("Test _max" + this);
        BigInteger[] numbers = {BigInteger.valueOf(2), BigInteger.valueOf(4), BigInteger.valueOf(6), BigInteger.valueOf(8), BigInteger.valueOf(10)};
        BigInteger exp = BigInteger.valueOf(10);
        BigInteger res = Program._max(numbers);
        assertEquals(exp, res);
    }

    @Test
    void sumTest() {
        System.out.println("Test _sum" + this);
        BigInteger[] numbers = {BigInteger.valueOf(2), BigInteger.valueOf(4), BigInteger.valueOf(6), BigInteger.valueOf(8), BigInteger.valueOf(10)};
        BigInteger exp = BigInteger.valueOf(30);
        BigInteger res = Program._sum(numbers);
        assertEquals(exp, res);
    }

    @Test
    void multTest() {
        System.out.println("Test _mult" + this);
        BigInteger[] numbers = {BigInteger.valueOf(2), BigInteger.valueOf(4), BigInteger.valueOf(6), BigInteger.valueOf(8), BigInteger.valueOf(10)};
        BigInteger exp = BigInteger.valueOf(3840);
        BigInteger res = Program._mult(numbers);
        assertEquals(exp, res);
    }

    @Test
    void resultEmpty() {//дополнительный тест
        System.out.println("Test Empty" + this);
        ProgramService programService = new ProgramService();
        List<String> results = programService.getAll();
        assertTrue(results.isEmpty());
    }

    void generate(int number_file, int kol_vo) throws IOException {
        for (int i = 1; i <= number_file; i++) {
            String name = "file_" + i + ".txt";
            PrintWriter printWriter = new PrintWriter(new FileWriter(name));
            Random random = new Random();
            for (int j = 0; j < kol_vo; j++) {
                printWriter.print(random.nextInt(10000)+" ");
            }
            printWriter.close();
        }
    }

    long time_min(int number_file, int kol_vo) throws IOException {
        long total_min = 0;
        for (int i = 1; i < number_file; i++) {
            String name = "file_" + i + ".txt";
            BigInteger[] numbers = Program.readFile(name);
            long start = System.nanoTime();
            Program._min(numbers);
            long end = System.nanoTime();
            total_min += (end - start);

            new File(name).delete();
        }
        return total_min /  number_file;
    }

    @Test
    void timeTest_min() throws IOException {
        int number_file = 1000;
        int kol_vo = 10000;
        generate(number_file, kol_vo);
        long average = time_min(number_file, kol_vo);
        System.out.println("Average time min " + kol_vo + " : " + average);
    }

    long time_max(int number_file, int kol_vo) throws IOException {
        long total_max = 0;
        for (int i = 1; i < number_file; i++) {
            String name = "file_" + i + ".txt";
            BigInteger[] numbers = Program.readFile(name);
            long start = System.nanoTime();
            Program._max(numbers);
            long end = System.nanoTime();
            total_max += (end - start);

            new File(name).delete();
        }
        return total_max / number_file;
    }

    @Test
    void timeTest_max() throws IOException {
        int number_file = 1000;
        int kol_vo = 10000;
        generate(number_file, kol_vo);
        long average = time_max(number_file, kol_vo);
        System.out.println("Average time max " + kol_vo + " : " + average);
    }

    long time_sum(int number_file, int kol_vo) throws IOException {
        long total_sum = 0;
        for (int i = 1; i < number_file; i++) {
            String name = "file_" + i + ".txt";
            BigInteger[] numbers = Program.readFile(name);
            long start = System.nanoTime();
            Program._sum(numbers);
            long end = System.nanoTime();
            total_sum += (end - start);

            new File(name).delete();
        }
        return total_sum /  number_file;
    }

    @Test
    void timeTest_sum() throws IOException {
        int number_file = 1000;
        int kol_vo = 10000;
        generate(number_file, kol_vo);
        long average = time_sum(number_file, kol_vo);
        System.out.println("Average time sum " + kol_vo + " : " + average);
    }

    long time_mult(int number_file, int kol_vo) throws IOException {
        long total_mult = 0;
        for (int i = 1; i < number_file; i++) {
            String name = "file_" + i + ".txt";
            BigInteger[] numbers = Program.readFile(name);
            long start = System.nanoTime();
            Program._mult(numbers);
            long end = System.nanoTime();
            total_mult += (end - start);

            new File(name).delete();
        }
        return total_mult / number_file;
    }

    @Test
    void timeTest_mult() throws IOException {
        int number_file = 1000;
        int kol_vo = 10000;
        generate(number_file, kol_vo);
        long average = time_mult(number_file, kol_vo);
        System.out.println("Average time mult " + kol_vo + " : " + average);
    }
}
