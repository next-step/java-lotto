package lotto.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomStrategy implements Strategy {
    private static final int GENERATE_COUNT = 6;

    Set<Integer> numbers = new HashSet<>();

    private int addNumber() {
        resetIfGenerateCountOver();
        int number = genNumber();
        while ( numbers.contains(number)) {
            number =  genNumber();
        }
        numbers.add(number);
        return number;
    }

    private void resetIfGenerateCountOver() {
        if( numbers.size() >= GENERATE_COUNT) {
            numbers.clear();
        }
    }

    private int genNumber() {
        return new Random().nextInt(LottoNumber.MAX_NUMBER) + LottoNumber.MIN_NUMBER;
    }

    public Integer generateNumber() {
        return addNumber();
    }
}
