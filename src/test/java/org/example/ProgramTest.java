package org.example;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {

    private static final int NUMBER_FILE = 1000;
    private static final int KOL_VO = 10000;
    private static ArrayList<BigInteger> dataIntTest;

    @BeforeAll
    public static void setUp() throws IOException {
        generate(NUMBER_FILE, KOL_VO);
        dataIntTest = new ArrayList<>();
        dataIntTest.add(BigInteger.valueOf(2));
        dataIntTest.add(BigInteger.valueOf(4));
        dataIntTest.add(BigInteger.valueOf(6));
        dataIntTest.add(BigInteger.valueOf(8));
        dataIntTest.add(BigInteger.valueOf(10));
    }

    @Test
    void minTest() {
        System.out.println("Test _min" + this);
        BigInteger expected = BigInteger.valueOf(2);

        BigInteger result = Program.min(dataIntTest);

        assertEquals(expected, result);
    }

    @Test
    void maxTest() {
        System.out.println("Test _max" + this);
        BigInteger expected = BigInteger.valueOf(10);

        BigInteger result = Program.max(dataIntTest);

        assertEquals(expected, result);
    }

    @Test
    void sumTest() {
        System.out.println("Test _sum" + this);
        BigInteger expected = BigInteger.valueOf(30);

        BigInteger result = Program.sum(dataIntTest);

        assertEquals(expected, result);
    }

    @Test
    void multTest() {
        System.out.println("Test _mult" + this);
        BigInteger expected = BigInteger.valueOf(3840);

        BigInteger result = Program.mult(dataIntTest);

        assertEquals(expected, result);
    }

    @Test
    void resultEmpty() {
        System.out.println("Test Empty" + this);
        ProgramService programService = new ProgramService();
        List<String> results = programService.getAll();
        assertTrue(results.isEmpty());
    }

    @Disabled
    @Test
    void testReadFileThrowsIOException() {
        String nonExistentFileName = "nonExistentFile.txt";
        assertThrows(IOException.class, () -> {
            Program.readFile(nonExistentFileName);
        });
    }

    @Test
    void timeOut() {
        Assertions.assertTimeout(Duration.ofMillis(100), () -> {
            return "result";
        });
    }


    long time_min(int number_file, int kol_vo) throws IOException {
        long total_min = 0;
        for (int i = 1; i < number_file; i++) {
            String name = "file_" + i + ".txt";
            ArrayList<BigInteger> numbers = Program.readFile(name);
            long start = System.nanoTime();
            Program.min(numbers);
            long end = System.nanoTime();
            total_min += (end - start);

            new File(name).delete();
        }
        return total_min / number_file;
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
            ArrayList<BigInteger> numbers = Program.readFile(name);
            long start = System.nanoTime();
            Program.max(numbers);
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
            ArrayList<BigInteger> numbers = Program.readFile(name);
            long start = System.nanoTime();
            Program.sum(numbers);
            long end = System.nanoTime();
            total_sum += (end - start);

            new File(name).delete();
        }
        return total_sum / number_file;
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
            ArrayList<BigInteger> numbers = Program.readFile(name);
            long start = System.nanoTime();
            Program.mult(numbers);
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

    @AfterAll
    public static void tearDown() {
        for (int i = 1; i <= NUMBER_FILE; i++) {
            new File("file_" + i + ".txt").delete();
        }
    }

    private static void generate(int number_file, int kol_vo) throws IOException {
        for (int i = 1; i <= number_file; i++) {
            String name = "file_" + i + ".txt";
            PrintWriter printWriter = new PrintWriter(new FileWriter(name));
            Random random = new Random();
            for (int j = 0; j < kol_vo; j++) {
                printWriter.print(random.nextInt(10000) + " ");
            }
            printWriter.close();
        }
    }
}
