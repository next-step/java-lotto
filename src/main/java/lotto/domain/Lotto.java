package lotto.domain;

import lotto.exception.InvalidLottoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int PRICE = 1_000;
    public static final int NUMBER_COUNT = 6;

    private Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lotto) {
        if (lotto.size() != NUMBER_COUNT) {
            throw new InvalidLottoGame(String.format("%s %s",InvalidLottoGame.INVALID_LOTTO_GAME,lotto.size()));
        }
        lottoNumbers = lotto;
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

    private boolean containsNumber(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        List<LottoNumber> numbers = new ArrayList<LottoNumber>(lottoNumbers);
        Collections.sort(numbers);
        return numbers.toString();
    }
}
