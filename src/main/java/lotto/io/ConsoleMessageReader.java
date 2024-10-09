package lotto.io;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleMessageReader implements MessageReader {
    final Scanner scanner;

    public ConsoleMessageReader(final InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public int readInt() {
        final int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }
}
