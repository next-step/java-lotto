package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoGame {
    public static final int PRICE = 1000;

    private static final int LOTTO_NUMBER_COUNT = 6;

    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public LottoGame() {
        while(lottoNumbers.size() < LOTTO_NUMBER_COUNT) {
            lottoNumbers.add(new LottoNumber(new RandomNumber()));
        }
        isValid();
    }

    public LottoGame(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static boolean isAffordable(int money) {
        return money >= PRICE;
    }

    public static LottoGame buy(int money) {
        return new LottoGame();
    }

    public boolean isValid() {
        return this.lottoNumbers.size() == LOTTO_NUMBER_COUNT;
    }

}
