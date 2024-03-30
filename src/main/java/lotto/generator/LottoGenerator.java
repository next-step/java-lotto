package lotto.generator;

import lotto.model.Lotto;

public class LottoGenerator {
    public Lotto generateLottoNumbers(LottoGeneratorStrategy lottoGeneratorStrategy) {
        if (lottoGeneratorStrategy == null) {
            throw new IllegalArgumentException("수동, 또는 전략 로또 생성 패턴을 주입해야 합니다.");
        }

        return lottoGeneratorStrategy.lottoGenerator();
    }
}
