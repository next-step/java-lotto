package lotto.domain;

import java.text.MessageFormat;

public class LottoResult {

    private LottoMachine.LottoType lottoType;
    private int numberOfMatches;

    private LottoResult(LottoMachine.LottoType lottoType, int numberOfMatches) {
        this.lottoType = lottoType;
        this.numberOfMatches = numberOfMatches;
    }

    public static LottoResult create(LottoMachine.LottoType lottoType, int numberOfMatches) {
        return new LottoResult(lottoType, numberOfMatches);
    }

    public int reward() {
        return lottoType.computeReward(numberOfMatches);
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} - {1}개", lottoType, numberOfMatches);
    }
}
