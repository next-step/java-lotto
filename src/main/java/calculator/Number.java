package calculator;

public class Number {

    private static final String MESSAGE_NUMBER_FORMAT = "숫자 형식 데이터가 아닙니다";
    private static final String MESSAGE_NEGATIVE_NUMBER = "음수가 입력되었습니다";

    private final int number;

    public Number(String number) {
        this.number = valid(number);
    }

    private int valid(String text) {
        int num;
        try {
            num = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(MESSAGE_NUMBER_FORMAT);
        }

        if (num < 0) {
            throw new RuntimeException(MESSAGE_NEGATIVE_NUMBER);
        }
        if(isEmpty(text)) {
            return 0;
        }
        return num;
    }


    public boolean isEmpty(String text) {
        if (text == null) {
            return true;
        }

        if (text.isEmpty()) {
            return true;
        }
        return false;
    }

    public int getNumber() {
        return number;
    }
}
