package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        Map<LottoMatch, Long> map = this.lottoLines.stream()
            .map(lottoLine -> lottoLine.getLottoMatch(winNums))
            .filter(lottoMatch -> lottoMatch != LottoMatch.NOT_FOUND)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new LottoMatchResult(map, totalPrice);
    }
}
