package lotto.view.result;

import lotto.constant.Rank;
import lotto.domain.LottoGameResult;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottoes;

public class ResultView {

    public static void printLottoNumbers(Lottoes lottoes) {
        System.out.println(lottoes.getValue().size() + "개를 구매했습니다.");
        for (LottoNumbers lottoNumber : lottoes.getValue()) {
            System.out.println(lottoNumber.getValue().toString());
        }
        System.out.println();
    }

    public static void printLottoGameResult(LottoGameResult lottoGameResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        lottoGameResult.getValue().entrySet().stream()
                .filter(entry -> !entry.getKey().equals(Rank.FIFTH))
                .forEach(entry -> System.out.println(entry.getKey().getDescription() + entry.getValue()));
    }

    public static void printWinningStatistics(double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
