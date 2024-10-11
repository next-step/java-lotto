package lotto.io;

public class ConsoleMessageWriter implements MessageWriter {
    @Override
    public void write(final String message) {
        System.out.println(message);
    }
}