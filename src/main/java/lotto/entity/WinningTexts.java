package lotto.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WinningTexts extends LottoNumberRange {

    private WinningTexts() {

    }

    public static Set<Integer> numbers(String[] text) {
        return validate(toInts(text));
    }

    private static Set<Integer> toInts(String[] values) {
        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            Integer winningNumber = toInt(value);
            validateRange(winningNumber);
            result.add(winningNumber);
        }
        return new HashSet<>(result);
    }

    private static Integer toInt(String value) {
        return Integer.parseInt(value);
    }

    private static Set<Integer> validate(Set<Integer> result) {
        LottoNumberSize.validateSize(result);
        return result;
    }
}
