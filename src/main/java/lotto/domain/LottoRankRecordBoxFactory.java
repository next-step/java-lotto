package lotto.domain;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class LottoRankRecordBoxFactory {

    private LottoRankRecordBoxFactory() {
    }

    public static LottoRankRecordBox createLottoRankRecordBox(List<WinningResult> winningResults) {
        List<LottoRankRecord> lottoRankRecords = recordWinRank(winningResults);
        return new LottoRankRecordBox(lottoRankRecords);
    }

    private static List<LottoRankRecord> recordWinRank(List<WinningResult> winningResults) {
        return winningResults.stream()
                .collect(groupingBy(LottoRank::findRank, counting()))
                .entrySet().stream()
                .map((entry) -> new LottoRankRecord(entry.getKey(), entry.getValue().intValue()))
                .collect(toList());
    }
}
