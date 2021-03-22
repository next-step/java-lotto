package lotto.dto;

import static lotto.domain.LottoPlay.*;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int lottoNumber;

    static {
        for (int number = LOTTO_MIN; number <= LOTTO_MAX; number++) {
            LOTTO_NUMBER.add(new LottoNumber(number));
        }
    };

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN || lottoNumber > LOTTO_MAX) {
            throw new IllegalArgumentException();
        }

        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber - lottoNumber.getLottoNumber();
    }
}
