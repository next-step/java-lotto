package step2.io;

import java.util.Scanner;

public class StandardInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
