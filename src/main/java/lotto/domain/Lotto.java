package lotto.domain;

public class Lotto {
    public static final Money PRICE = Money.from(1_000);

    private final LottoNumbers numbers;
    private final LottoType type;

    private Lotto(final LottoNumbers numbers, final LottoType type) {
        this.numbers = numbers;
        this.type = type;
    }

    public static Lotto manual(final LottoNumbers numbers) {
        return new Lotto(numbers, LottoType.MANUAL);
    }

    public static Lotto automatic() {
        return new Lotto(LottoNumbersGenerator.randomNumbers(), LottoType.AUTOMATIC);
    }

    public boolean isAutomatic() {
        return this.type.isAutomatic();
    }

    public boolean isManual() {
        return this.type.isManual();
    }

    public WinningOrder winResult(final WinningNumber winningNumber) {
        return winningNumber.winResult(this.numbers);
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }
}
