package lotto.domain;

public class StringLottoGenerator implements LottoGenerator {

    private final String lottoString;

    public StringLottoGenerator(String lottoString) {
        this.lottoString = lottoString;
    }

    @Override
    public Lotto generate() {
        return Lotto.create(this.lottoString);
    }
}
