package step2.domain;

import java.util.List;

/**
 * 로또 엔터티
 */
public class Lotto {
    private final static int LOTTO_PRICE = 1000;
    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getNumbers();
    }
}
