package lotto.domain;

public class Lotto {
    public static final Money PRICE = Money.from(1_000);

    private final LottoNumbers numbers;

    private Lotto(final LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public static Lotto manual(final LottoNumbers numbers) {
        return new Lotto(numbers);
    }

    public static Lotto automatic() {
        return new Lotto(LottoNumbersGenerator.randomNumbers());
    }

    public long howManyMatches(final LottoNumbers winningNumber) {
        return this.numbers
                .howManyMatches(winningNumber)
                ;
    }

    public WinningOrder winResult(final WinningNumber winningNumber) {
        return winningNumber.winResult(this.numbers);
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }
}
