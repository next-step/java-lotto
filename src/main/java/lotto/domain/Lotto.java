package lotto.domain;

import lotto.exception.InvalidLottoGame;
import lotto.exception.InvalidLottoNumber;

import java.util.*;

public class Lotto {
    public static final int PRICE = 1_000;
    public static final int NUMBER_COUNT = 6;

    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public Lotto(LottoNumberFactory factory) {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            lottoNumbers.add(factory.generateNumber());
        }
    }

    public Lotto(List<Integer> numbers) {
        verifyLottoNumbers(numbers);
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

    }

    public static void verifyLottoNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != NUMBER_COUNT) {
            throw new InvalidLottoNumber(numbers.toString());
        }
    }

    public Rank matchCount(Lotto other) {
        int count = 0;
        for (LottoNumber number : lottoNumbers) {
            count = other.increaseCountIfContains(number,count);
        }
        return Rank.of(count);
    }

    private int increaseCountIfContains(LottoNumber number, int count) {
        if (containsNumber(number)) {
            return count + 1;
        }
        return count;
    }

    public boolean containsNumber(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        List<LottoNumber> numbers = new ArrayList<LottoNumber>(lottoNumbers);
        Collections.sort(numbers);
        return numbers.toString();
    }
}
