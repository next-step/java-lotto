package lotto.domain;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;

public class LottoRankRecordBoxFactory {

    private LottoRankRecordBoxFactory() {
    }

    public static LottoRankRecordBox createLottoRankRecordBox(List<WinningResult> winningResults) {
        List<LottoRankRecord> lottoRankRecords = recordWinRank(winningResults);
        return new LottoRankRecordBox(lottoRankRecords);
    }

    private static List<LottoRankRecord> recordWinRank(List<WinningResult> winningResults) {
        EnumMap<LottoRank, Long> enumMap = winningResults.stream()
                .collect(groupingBy(LottoRank::findRank, () -> new EnumMap<>(LottoRank.class), counting()));
        EnumSet.allOf(LottoRank.class).forEach(lottoRank -> enumMap.putIfAbsent(lottoRank, 0L));

        return enumMapToList(enumMap);
    }

    private static List<LottoRankRecord> enumMapToList(EnumMap<LottoRank, Long> enumMap) {
        return enumMap.entrySet().stream()
                .map((entry) -> new LottoRankRecord(entry.getKey(), entry.getValue().intValue()))
                .collect(toList());
    }
}
