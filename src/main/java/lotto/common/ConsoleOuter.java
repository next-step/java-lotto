package lotto.common;

public class ConsoleOuter implements Outer {
    @Override
    public void print(String value) {
        System.out.println(value);
    }
}
