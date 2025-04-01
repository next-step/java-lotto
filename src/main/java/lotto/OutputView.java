package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private final List<LottoRank> printTargetRank = List.of(
            LottoRank.FIFTH,
            LottoRank.FOURTH,
            LottoRank.THIRD,
            LottoRank.SECOND,
            LottoRank.FIRST
    );

    public void printResult(LottoRank[] lottoResults) {
        Map<LottoRank, Long> collect = Arrays.stream(lottoResults)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
        printTargetRank.forEach(rank ->
                    printLottoRank(rank, Math.toIntExact(collect.getOrDefault(rank, 0L)))
        );
    }

    private void printLottoRank(LottoRank lottoRank, int count) {
        System.out.println(lottoRank.getCountOfMatch() + "개 일치" + "(" + lottoRank.getWinningMoney() + ")-" + count + "개");
    }
}
