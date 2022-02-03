package lotto.domain;

import java.util.List;

public class LottoMatcher {

    public static int compare(List<Integer> numbers, List<Integer> lotto) {
        int count = 0;

        for (Integer number : lotto) {
            if (isContain(numbers, number)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isContain(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }
}
