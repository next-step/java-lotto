package lotto.view.result;

import lotto.domain.Rank;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottoes;

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
        String first = "6개 일치 (2,000,000,000원) - " + ranks.get(Rank.FIRST);
        String second = "5개 일치 (1,500,000원) - " + ranks.get(Rank.SECOND);
        String third = "4개 일치 (50,000원) - " + ranks.get(Rank.THIRD);
        String fourth = "3개 일치 (5,000원) - " + ranks.get(Rank.FOURTH);

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(fourth);
        System.out.println(third);
        System.out.println(second);
        System.out.println(first);

    }

    public static void printWinningStatistics(double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
