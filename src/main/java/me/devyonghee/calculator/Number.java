package me.devyonghee.calculator;

public final class Number {

    private final int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number from(String string) {
        return new Number(parseInt(string));
    }

    private static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("number value(%s) must be number format", string), e);
        }
    }
}
