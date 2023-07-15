package lottogame.console.util;

import java.util.Scanner;

public class LocalScanner {

    private final Scanner scanner;

    private LocalScanner() {
        this.scanner = new Scanner(System.in);
    }

    public static LocalScanner getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public String next() {
        return scanner.next();
    }

    public int nextInt() {
        int answer = scanner.nextInt();
        clearBuffer();
        return answer;
    }

    private void clearBuffer() {
        scanner.nextLine();
    }

    private static final class SingletonHelper {

        private static final LocalScanner INSTANCE = new LocalScanner();

    }

}
