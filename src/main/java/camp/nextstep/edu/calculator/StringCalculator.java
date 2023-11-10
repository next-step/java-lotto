package camp.nextstep.edu.calculator;

public class StringCalculator {

    public static int calc(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백이나 null이 올 수 없습니다");
        }

        return 0;
    }
}
