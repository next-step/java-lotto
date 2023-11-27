package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    public static final String DELIMITER = ", ";
    Scanner scanner = new Scanner(System.in);

    public int inputIntegerCommand(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> inputListCommand(String message) {
        System.out.println(message);
        String result = scanner.nextLine();
        return Arrays.stream(result.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> inputManualListCommand(String message, Integer count) {
        System.out.println(message);
        return Stream.generate(
                        () -> Arrays.stream(scanner.nextLine().split(DELIMITER))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                ).limit(count)
                .collect(Collectors.toList());
    }
}
