package util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    public static final OutputView outputView = new OutputView();
    public static final InputView inputView = new InputView();

    public static class OutputView {
        public void println(String message) {
            System.out.println(message);
        }

        public void println() {
            this.println("");
        }

        public void printf(String format, Object... args) {
            System.out.printf(format, args);
            this.println();
        }
    }

    public static class InputView {
        private static final Scanner scanner = new Scanner(System.in);

        public static int inputInt() {
            int value = scanner.nextInt();
            scanner.nextLine();
            return value;
        }

        public static String inputString() {
            return scanner.nextLine();
        }

        public static List<String> inputStrings(String delimiter) {
            return Arrays.stream(scanner.nextLine().split(delimiter))
                    .map(string -> string.trim())
                    .collect(Collectors.toList());
        }

        public static List<Integer> inputStringsToIntegers(String delimiter) {
            return inputStrings(delimiter)
                    .stream()
                    .mapToInt(i -> Integer.valueOf(i))
                    .boxed()
                    .collect(Collectors.toList());
        }
    }
}
