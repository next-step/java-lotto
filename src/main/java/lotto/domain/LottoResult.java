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
        return lottoType.getPrice() * numberOfMatches;
    }

    @Override
    public String toString() {
        int matchCount = lottoType.getMatchCount();
        int price = lottoType.getPrice();
        return MessageFormat.format("{0}개 일치 ({1}원) - {2}개", matchCount, price, matchCount);
    }
}
