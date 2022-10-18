package step1.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Views {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String QUESTIONS = "계산할 문자열을 입력하세요.";
    private static final String BLANK = " ";
    private static final String OUTPUT = "계산결과 = ";

    private Views() {
    }

    public static List<String> input() {
        System.out.println(QUESTIONS);
        return Arrays.asList(SCANNER.nextLine().split(BLANK));
    }

    public static void output(int result) {
        System.out.println(OUTPUT + result);
    }
}
