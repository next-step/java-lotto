package step4.domain;

/**
 * 로또 엔터티
 */
public class Lotto {
    private static final Amount DEFAULT_LOTTO_PRICE = new Amount(1_000);
    private final LottoNumbers lottoNumbers;
    private final Amount price;

    public Lotto() {
        this(LottoNumbers.ofAuto(), DEFAULT_LOTTO_PRICE);
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this(lottoNumbers, DEFAULT_LOTTO_PRICE);
    }

    public Lotto(LottoNumbers lottoNumbers, Amount price) {
        this.lottoNumbers = lottoNumbers;
        this.price = price;
    }

    // 다른 로또와 비교해서 일치하는 숫자 개수 반환
    private int matchCount(LottoNumbers target) {
        return (int)lottoNumbers.numbers()
            .stream()
            .filter(target::contains)
            .count();
    }

    private boolean containNumber(int number) {
        return lottoNumbers.contains(number);
    }

    public String numbersToString() {
        return lottoNumbers.numbers()
            .toString();
    }

    public MatchResult match(LottoNumbers target, int bonusNumber) {
        int matchCount = matchCount(target);
        boolean hasBonus = containNumber(bonusNumber);
        return new MatchResult(matchCount, hasBonus);
    }

    public Amount price() {
        return price;
    }

    public static Amount defaultPrice() {
        return DEFAULT_LOTTO_PRICE;
    }
}
