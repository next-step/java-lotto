package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoPaper {

    private final List<LottoLine> lottoLines;

    public LottoPaper(List<LottoLine> lottoLines) {
        this.lottoLines = lottoLines;
    }

    public List<LottoLine> getAutoLottoLines() {
        return this.lottoLines.stream()
            .filter(LottoLine::isAuto)
            .collect(Collectors.toList());
    }

    public List<LottoLine> getManualLottoLines() {
        return this.lottoLines.stream()
            .filter(LottoLine::isManual)
            .collect(Collectors.toList());
    }

    public LottoMatchResult getResult(LottoNums winNums, LottoNum bonusNum, int totalPrice) {
        Map<Rank, Long> map = this.lottoLines.stream()
            .map(lottoLine -> lottoLine.getRank(winNums, bonusNum))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new LottoMatchResult(new EnumMap<>(map), totalPrice);
    }
}
