package lotto.domain;

import lotto.exception.InvalidLottoNumbersException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int SUBLIST_START_INDEX = 0;

    private int lottoNumber;

    private static final List<LottoNumber> numbersWithinRange = IntStream
            .rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(toList());

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static int valueOf(LottoNumber lottoNumber) {
        return lottoNumber.lottoNumber;
    }

    public static List<LottoNumber> getRandomListInstance(int size) {
        Collections.shuffle(numbersWithinRange, new Random(System.currentTimeMillis()));

        return new ArrayList<>(numbersWithinRange.subList(SUBLIST_START_INDEX, size));
    }

    public static LottoNumber getInstance(int number) {
        if (!isValidNumber(number)) {
            throw new InvalidLottoNumbersException();
        }

        Collections.sort(numbersWithinRange);

        return numbersWithinRange.get(numberToIndex(number));
    }

    private static boolean isValidNumber(int number) {
        return MIN_LOTTO_NUMBER <= number &&
                number <= MAX_LOTTO_NUMBER;
    }

    private static int numberToIndex(int number) {
        return number - 1;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return lottoNumber > o.lottoNumber ? 1 : -1;
    }
}
