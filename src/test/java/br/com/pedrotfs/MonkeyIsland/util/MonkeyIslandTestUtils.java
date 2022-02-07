package br.com.pedrotfs.MonkeyIsland.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonkeyIslandTestUtils {

    public static final String INPUT_OK = "{\n" +
            "\"island\": [ \n" +
            "[\"1\", \"3\", \"3\"],\n" +
            "[\"2\", \"1\", \"4\"], \n" +
            "[\"0\", \"6\", \"4\"] \n" +
            "\n" +
            "] \n" +
            "\n" +
            "}";

    public static final String INPUT_NOK = "{\n" +
            "\"island\": [ \n" +
            "[\"1\", \"3\", \"3\"],\n" +
            "[\"2\", \"1\", \"4\"], \n" +
            "[\"0\", \"6\"] \n" +
            "\n" +
            "] \n" +
            "\n" +
            "}";

    public static final String INPUT_INVALID = "{SAJKDHASDKJSHDKJ}";

    public static List<List<Integer>> buildInputMatrixOK() {
        List<List<Integer>> matrix = new ArrayList<>();
        Integer [] line1 = new Integer [] {1, 3, 3 };
        Integer [] line2 = new Integer [] {2, 1, 4 };
        Integer [] line3 = new Integer [] {0, 6, 4 };

        matrix.add(new ArrayList<>(new ArrayList<>(Arrays.asList(line1))));
        matrix.add(new ArrayList<>(new ArrayList<>(Arrays.asList(line2))));
        matrix.add(new ArrayList<>(new ArrayList<>(Arrays.asList(line3))));

        return matrix;
    }

    public static List<List<Integer>> buildInputMatrixNOK() {
        List<List<Integer>> matrix = new ArrayList<>();
        Integer [] line1 = new Integer [] {1, 3, 3 };
        Integer [] line2 = new Integer [] {2, 4 };
        Integer [] line3 = new Integer [] {0, 6, 4 };

        matrix.add(new ArrayList<>(new ArrayList<>(Arrays.asList(line1))));
        matrix.add(new ArrayList<>(new ArrayList<>(Arrays.asList(line2))));
        matrix.add(new ArrayList<>(new ArrayList<>(Arrays.asList(line3))));

        return matrix;
    }


}
