package me.daeho.lotto.domain;

import java.util.*;

public class RandomLottoNumber {
    private static final int NUMBER_COUNT = 6;

    public static List<LottoNumber> make() {
        Set<LottoNumber> randomNumbers = new HashSet<>(NUMBER_COUNT);
        while(randomNumbers.size() != NUMBER_COUNT) {
            randomNumbers.add(LottoNumber.random());
        }
        List<LottoNumber> numbers = new ArrayList<>(randomNumbers);
        Collections.shuffle(numbers);
        return numbers;
    }
}

