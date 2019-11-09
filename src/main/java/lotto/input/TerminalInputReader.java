package lotto.input;

import java.util.Scanner;

public class TerminalInputReader implements InputReader {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public int readInt(String comment) {
        System.out.println(comment);
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String readLine(String comment) {
        System.out.println(comment);
        return scanner.nextLine();
    }
}
