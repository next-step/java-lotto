package step3.ui;

import java.util.Scanner;

public class StandardInput implements Input {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
