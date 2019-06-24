package lotto.common;

public class ConsoleOuter implements Outer {
    @Override
    public void print(final String value) {
        System.out.println(value);
    }
}
