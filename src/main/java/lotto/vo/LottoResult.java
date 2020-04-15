package lotto.vo;

import java.util.Map;

public class LottoResult {

    private final Map<LottoGrade, LottoResultCount> matchResult;

    public LottoResult(final Map<LottoGrade, LottoResultCount> result) {
        matchResult = result;
    }

    public LottoResultCount getCountWithGrade(LottoGrade grade) {
        return matchResult.getOrDefault(grade, new LottoResultCount());
    }

    public int getPrize() {
        int total = 0;
        for (Map.Entry<LottoGrade, LottoResultCount> pair : matchResult.entrySet()) {
            total += pair.getValue().getPrize(pair.getKey().toMoney());
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 3; i <= 6; ++i) {
            sb.append(makePrizeStringWithCount(i));
        }

        return sb.toString();
    }

    private String makePrizeStringWithCount(final int count) {

        final LottoGrade grade = LottoGrade.fromMatchCount(count);

        return String.format("%d개 일치 (%s원) - %d개\n"
                , count
                , grade.toMoney()
                , matchResult.getOrDefault(grade, new LottoResultCount()).getCount()
        );
    }
}
