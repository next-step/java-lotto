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

    // 다른 로또와 비교해서 일치하는 숫자 개수 반환
    public int getMatchCount(LottoNumbers target) {
        int matchCount = 0;
        for (Integer number : lottoNumbers.getNumbers()) {
            if (target.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public String getLottoNumbers() {
        return lottoNumbers.getNumbers()
            .toString();
    }
}
