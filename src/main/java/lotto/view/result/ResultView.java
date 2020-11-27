package lotto.view.result;

import lotto.constant.Rank;
import lotto.domain.LottoGameResult;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottoes;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottoNumbers(Lottoes lottoes) {
        System.out.println(lottoes.getValue().size() + "개를 구매했습니다.");
        for (LottoNumbers lottoNumbers : lottoes.getValue()) {
            System.out.println(lottoNumbers.getIntegerValues().toString());
        }
        System.out.println();
    }

    public static void printLottoGameResult(Map<Rank, Integer> ranks) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        ranks.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey().getDescription() + entry.getValue()));
    }

    public static void printWinningStatistics(double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
