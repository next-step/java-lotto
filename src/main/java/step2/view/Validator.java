package step2.view;

import static java.util.stream.Collectors.toSet;
import static step2.util.StringConstant.DELIMITER_COMMA;

import java.util.Arrays;
import java.util.Set;
import step2.domain.Number;

public class Validator {

    public static void validateMinSeed(int seed) {
        if (seed < 1_000) {
            throw new IllegalArgumentException("최소 구입금액은 1000원입니다.");
        }
    }

    public static void validateMinManualCount(int manualCount) {
        if (manualCount < 0) {
            throw new IllegalArgumentException("최소 0게임부터 수동구매 가능합니다.");
        }
    }

    public static void validateGame(String input) {
        String[] stringNumbers = input.split(DELIMITER_COMMA);
        validateGameLength(stringNumbers);

        Set<Number> collect = Arrays.stream(stringNumbers)
            .map(stringNumber -> {
                int intValue = validateParesInt(stringNumber);
                validateNumberRange(intValue);
                return new Number(intValue);
            })
            .collect(toSet());
        validateDuplicatedNumber(collect);
    }

    public static int validateParesInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력가능합니다");
        }
    }

    public static void validateNumberRange(int value) {
        if (value <= 0 || value >= 46) {
            throw new IllegalArgumentException("1~45까지 입력가능합니다.");
        }
    }

    public static void validateGameLength(String[] game) {
        if (game.length != 6) {
            throw new IllegalArgumentException("번호 6개를 입력하세요.");
        }
    }

    public static void validateDuplicatedNumber(Set<Number> collect) {
        if (collect.size() != 6) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }
}
