package lotto.domain;

public class Lotto {
    public static final int PRICE = 1_000;

    private final LottoNumbers numbers;

    private Lotto(final LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public static Lotto manual(final LottoNumbers numbers) {
        return new Lotto(numbers);
    }

    public static Lotto automatic() {
        return new Lotto(LottoNumbers.randomNumbers());
    }

    public long howManyMatches(final LottoNumbers winningNumber) {
        return this.numbers
                .howManyMatches(winningNumber)
                ;
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }
}
