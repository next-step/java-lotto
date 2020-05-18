package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPaper {
    private final List<LottoLine> lottoLines;

    public LottoPaper(List<LottoLine> lottoLines) {
        this.lottoLines = lottoLines;
    }

    public int getCount() {
        return this.lottoLines.size();
    }

    public List<LottoLine> getLottoLines() {
        return new ArrayList<>(lottoLines);
    }

    public LottoMatchResult getResult(LottoNums winNums, int totalPrice) {
        final LottoMatchResult lottoMatchResult = new LottoMatchResult(totalPrice);
        this.lottoLines.forEach(lottoLine -> lottoLine.getLottoMatch(winNums)
            .ifPresent(lottoMatch -> lottoMatchResult.increment(lottoMatch)));

        return lottoMatchResult;
    }
}
