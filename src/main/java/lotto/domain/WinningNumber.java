package lotto.domain;

public class WinningNumber {
    private final LottoNumbers numbers;
    private final LottoNumber bonus;

    public WinningNumber(final LottoNumbers numbers, final LottoNumber bonus) {
        validate(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public WinningOrder winResult(final LottoNumbers lottoNumbers) {
        return WinningOrder.from(lottoNumbers.howManyMatches(numbers), lottoNumbers.contains(bonus));
    }

    private void validate(final LottoNumbers numbers, final LottoNumber bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }
}
