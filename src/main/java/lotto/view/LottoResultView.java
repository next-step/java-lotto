package lotto.view;

import lotto.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.enums.Rank;

import java.util.Map;

public class LottoResultView {
    public static void printLotto(Lotto lotto) {
        System.out.printf("수동으로 %d개, 자동으로 %d개 구매했습니다.\n", lotto.manualCount(), lotto.lottoNumbersCount() - lotto.manualCount());
        for (LottoNumbers numbers : lotto.getLottoNumbers()) {
            System.out.println(numbers);
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨결과\n================================");
        for (Map.Entry<Rank, Integer> entry : lottoResult.getWinningCountPerRank().entrySet()) {
            System.out.printf("%d개 일치", entry.getKey().getMatchCount());
            if (entry.getKey().getContainBonus()) {
                System.out.print(", 보너스볼 일치");
            }
            System.out.printf("(%d원) - %d개%n", entry.getKey().getPrizeAmount(), entry.getValue());
        }
        System.out.printf("총 수익률은 %.2f 입니다.%n", lottoResult.getRateOfReturn());
    }

    public static void printExceptionMsg(String msg) {
        System.out.println(msg);
    }
}
