package calculator;

public class Number {

    private Number() {}

    public static int valueOf(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다!");
        }

        return number;
    }
}
