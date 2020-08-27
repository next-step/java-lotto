package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputClass {
    private static final String DELIMETER = ",";

    public static int getUserIntInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> getUserStringInput() {
        Scanner scanner = new Scanner(System.in);
        return splitString(scanner);
    }

    private static List<Integer> splitString(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(DELIMETER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
