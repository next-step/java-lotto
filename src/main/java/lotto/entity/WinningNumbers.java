package lotto.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final String DEFAULT_SPLIT_DELIMITER = ", ";

    private WinningNumbers() {

    }

    public static List<Integer> numbers(String text) {
        return validate(toInts(text.split(DEFAULT_SPLIT_DELIMITER)));
    }

    private static List<Integer> toInts(String[] values) {
        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            result.add(toInt(value));
        }
        return result;
    }

    private static List<Integer> validate(List<Integer> result) {
        validateDuplication(result);
        validateSize(result);
        return result;
    }


    private static void validateDuplication(List<Integer> result) {
        Set<Integer> distinct = new HashSet<>(result);
        if (result.size() != distinct.size()) {
            throw new IllegalArgumentException("중복 된 당첨번호");
        }
    }

    private static void validateSize(List<Integer> result) {
        if (result.size() != 6) {
            throw new IllegalArgumentException("당첨 번호 여섯개 아님");
        }
    }


    private static Integer toInt(String value) {
        return Integer.parseInt(value);
    }

}
