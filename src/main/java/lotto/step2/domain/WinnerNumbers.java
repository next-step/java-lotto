package lotto.step2.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinnerNumbers {
    private final Set<Integer> nums;

    public WinnerNumbers(final String winnerNumbersText) {
        final Set<Integer> integers = conventStringToIntegerSet(winnerNumbersText);
        
        this.nums = integers;
    }

    private static Set<Integer> conventStringToIntegerSet(final String winnerNumbersText) {
        return Arrays.stream(winnerNumbersText.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public Set<Integer> nums() {
        return nums;
    }
}
