package lotto.domains;

public class UnsignedInteger {
    private final int value;

    public static UnsignedInteger parse(String string) {
        try {
            int value = Integer.parseUnsignedInt(string);
            return new UnsignedInteger(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("0 이상의 숫자 형식만 입력할 수 있습니다. 입력값: " + string);
        }
    }

    private UnsignedInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
