package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.out;

class OutputView {

    private static final List<LottoRank> printTargetRank = List.of(
            LottoRank.FIFTH,
            LottoRank.FOURTH,
            LottoRank.THIRD,
            LottoRank.SECOND,
            LottoRank.FIRST
    );

    public static void printResult(LottoRank[] lottoResults) {
        Map<LottoRank, Long> collect = Arrays.stream(lottoResults)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
        printTargetRank.forEach(rank ->
                    OutputView.printLottoRank(rank, Math.toIntExact(collect.getOrDefault(rank, 0L)))
        );
    }

    private static void printLottoRank(LottoRank lottoRank, int count) {
        System.out.println(lottoRank.getCountOfMatch() + "개 일치" + "(" + lottoRank.getWinningMoney() + ")-" + count + "개");
    }

    public static void printBoughtLottos(Lotto[] lottos) {
        out.println(lottos.length + "개를 구매했습니다.");
        Arrays.stream(lottos)
                .forEach(OutputView::printLotto);

    }

    private static void printLotto(Lotto lotto) {
        out.println(Arrays.toString(lotto.getLottoNumbers()));
    }
}
