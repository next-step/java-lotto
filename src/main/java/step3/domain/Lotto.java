package step3.domain;

/**
 * 로또 엔터티
 */
public class Lotto {
    private final static Integer LOTTO_PRICE = 1_000;
    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = LottoNumbers.randomized();
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Integer getLottoPrice() {
        return LOTTO_PRICE;
    }

    // 다른 로또와 비교해서 일치하는 숫자 개수 반환
    public int matchCount(LottoNumbers target) {
        return (int)lottoNumbers.numbers()
            .stream()
            .filter(target::contains)
            .count();
    }

    public boolean containNumber(int number) {
        return lottoNumbers.contains(number);
    }

    public String numbersToString() {
        return lottoNumbers.numbers()
            .toString();
    }
}
