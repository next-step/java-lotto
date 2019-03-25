package lotto.domain;

import lotto.parser.LottoNumberParser;

public class ManualLottoGenerator implements LottoGenerator {
    private final String lotto;

    public ManualLottoGenerator(String lotto) {
        this.lotto = lotto;
    }

    @Override
    public Lotto generate() {
        return LottoNumberParser.parseLotto(lotto);
    }
}
