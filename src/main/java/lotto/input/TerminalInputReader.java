package lotto.input;

import java.util.Optional;
import java.util.Scanner;

public class TerminalInputReader implements InputReader {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public Optional<Integer> readInt(String comment) {
        try {
            System.out.println(comment);
            return Optional.of(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Override
    public String readLine(String comment) {
        System.out.println(comment);
        return scanner.nextLine();
    }
}
