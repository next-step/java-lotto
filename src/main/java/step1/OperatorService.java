package step1;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class OperatorService {

    private static final String DELIMITER = " ";

    public int operate(final String input) {
        String[] split = input.split(DELIMITER);
        int a = 0, b;
        Operator op = null;
        for (int i = 0; i < split.length; i++) {
            if (StringUtils.isBlank(split[i])) {
                throw new IllegalArgumentException("유효한 입력값이 아닙니다.");
            }

            if (i == 0) {
                a = Integer.parseInt(split[i]);
                continue;
            }

            if (isEven(i)) {
                op = Operator.of(split[i]);
                continue;
            }

            b = Integer.parseInt(split[i]);
            a = op.calculate(a, b);
        }
        return a;
    }

    private boolean isEven(int index) {
        return index % 2 != 0;
    }
}
