package lotto.domain;

public class Lotto {

    private static final int TOTAL_PER_LOTTO = 6;

    private final LottoNumbers numbers;

    public Lotto() {
        this(new LottoRandomGenerator());
    }

    public Lotto(Long seed) {
        this(new LottoRandomGenerator(seed));
    }

    public Lotto(LottoRandomGenerator generator) {
        this(generator.generate(TOTAL_PER_LOTTO));
    }

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoNumbers getNumbers() {
        return this.numbers;
    }

}
