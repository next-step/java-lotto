package view;

import java.util.Scanner;

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
    }
}
