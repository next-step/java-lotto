package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumber {
    private static List<Integer> allNumbers = new ArrayList<>();

    static {
        for (int number = LottoNumber.MIN_NUMBER; number <= LottoNumber.MAX_NUMBER; number++) {
            allNumbers.add(number);
        }
    }

    public static int generateRandomNumbers() {
        Collections.shuffle(allNumbers);
        return allNumbers.get(0);
    }


}
