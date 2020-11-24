package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String CSV_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static Long getLong(String label) {
        System.out.println(label);
        return Long.parseLong(getInputLine());
    }

    public static List<Integer> getCommaSeparatedInteger(String label) {
        System.out.println(label);
        String winningBallsCsv = getInputLine();
        return Arrays.stream(winningBallsCsv.split(CSV_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    private static String getInputLine() {
        return scanner.nextLine();
    }
}
