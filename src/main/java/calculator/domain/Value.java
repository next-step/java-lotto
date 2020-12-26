package calculator.domain;

public class Value {
    private static final int ZERO = 0;

    public int validateNullAndEmpty(String inputValue) {
        if(inputValue == null ||inputValue.isEmpty()) {
            return ZERO;
        }

        return 1;
    }
}
