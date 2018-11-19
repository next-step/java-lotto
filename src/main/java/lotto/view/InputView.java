package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInteger(String question) {
        System.out.println(question);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> inputStrings(String question) {
        System.out.println(question);
        return Arrays.asList(scanner.nextLine().replaceAll("\\s+","").split(","));
    }
}
