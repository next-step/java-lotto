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
        return scanner.nextInt();
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }
}
