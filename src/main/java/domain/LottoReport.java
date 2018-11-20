package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoReport {
    private LottoResult lottoResult;
    
    public LottoReport(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }
    
    public List<String> getMatches() {
        List<String> result = new ArrayList<>();
        for (Rank rank : lottoResult.getRanks()) {
            int matchCount = lottoResult.matchCount(rank);
            result.add(String.format(matchedFormat(rank), rank.getMatchNumber(), rank.getPrizeMoney(), matchCount));
        }
        return result;
    }

    private String matchedFormat(Rank rank) {
        String matchedFormat = "%d개 일치 (%d원) - %d개";
        if (rank.equals(Rank.SECOND)) {
            matchedFormat = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
        }
        return matchedFormat;
    }

    public String getRate() {
        return String.format("총 수익률은 %.2f입니다.", lottoResult.calculatorRate());
    }
}
