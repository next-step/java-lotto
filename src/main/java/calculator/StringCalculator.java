package calculator;

import java.util.Objects;

class StringCalculator {
    public int calc(String input) {
        if(Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }

        String[] parsed = input.split(" ");
        int result = Integer.parseInt(parsed[0]);

        for (int i = 1; i < parsed.length; i += 2) {
            StringOperator operator = StringOperator.of(parsed[i]);
            int target = Integer.parseInt(parsed[i + 1]);
            result = operator.calc(result, target);
        }

        return result;
    }
}
