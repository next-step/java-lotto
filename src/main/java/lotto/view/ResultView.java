package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static void announceTotalLottoTicketCount(int countOfCustomLotto, int countOfAutoLotto) {
        System.out.println("수동으로 " + countOfCustomLotto + "장, 자동으로 " + countOfAutoLotto + "개를 구매했습니다.");
    }

    public static void announceTotalLottoNumbers(LottoPaper lottoPaper) {
        List<Lotto> lottos = lottoPaper.getLottos();

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static void resultStart() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void WinningResult(WinningResults winningResults) {
        WinningReport winningReport = winningResults.winningReport();
        Map<Award, Integer> winningResult = winningReport.awardResult();
        Arrays.stream(Award.values())
                .filter(award -> !award.equals(Award.MISS))
                .forEach(award ->
                        System.out.println(award.countOfMatch() + "개 일치 " +
                                "(" + award.winningMoney() + "원)- " +
                                winningResult.getOrDefault(award, 0) + "개"
                        )
                );

        System.out.println("총 수익률은 " + winningReport.rateOfReturn() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
