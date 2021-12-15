package lotto.domain;

public class LottoAutoGenerator implements LottoGenerator {

    private static final LottoNumbers SOURCE_LOTTO_NUMBERS = new LottoNumbers(1, 45);

    @Override
    public Lotto generate() {
        LottoNumbers lottoNumbers = SOURCE_LOTTO_NUMBERS.shuffle()
                .take(Lotto.LOTTO_NUMBERS_COUNT)
                .sort();

        return new Lotto(lottoNumbers);
    }
}
