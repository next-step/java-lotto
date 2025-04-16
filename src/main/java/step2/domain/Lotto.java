package step2.domain;

/**
 * 로또 엔터티
 */
public class Lotto {
    private final static Integer LOTTO_PRICE = 1_000;
    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Integer getLottoPrice() {
        return LOTTO_PRICE;
    }

    // 다른 로또와 비교해서 일치하는 숫자 개수 반환
    public int getMatchCount(LottoNumbers target) {
        return (int)lottoNumbers.getNumbers()
            .stream()
            .filter(target.getNumbers()::contains)
            .count();
    }


    public String getLottoNumbers() {
        return lottoNumbers.getNumbers()
            .toString();
    }
}
