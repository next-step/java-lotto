package lotto.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class RandomLottoNumber {
    private static List<Integer> allNumbers = new ArrayList<>();

    static {
        for (int number = LottoNumber.MIN_RANGE; number < LottoNumber.MAX_RANGE; number++) {
            allNumbers.add(number);
        }
    }

    public static Set<LottoNumber> generateRandomNumbers() {
        Collections.shuffle(allNumbers);
        return allNumbers.stream().limit(Lotto.SIZE)
                         .map(LottoNumber::valueOf)
                         .collect(Collectors.toSet());
    }
}
