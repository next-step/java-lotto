package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Prize;

import java.util.List;

public class ResultView {

    private static final double BREAK_EVEN = 1;
    private static final String LOSS_NOTICE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final List<Prize> PRIZES_IN_ORDER =
            List.of(Prize.FOURTH, Prize.THIRD, Prize.SECOND, Prize.FIRST);

    public void printLottos(List<Lotto> lottos) {
        System.out.println(toPurchaseMessage(lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(toLottoLine(lotto));
        }
        System.out.println();
    }

    public void printStatistics(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Prize prize : PRIZES_IN_ORDER) {
            System.out.println(toPrizeLine(prize, result.countOf(prize)));
        }
        System.out.println(toProfitRateMessage(result.profitRate()));
    }

    static String toPurchaseMessage(int count) {
        return count + "개를 구매했습니다.";
    }

    static String toLottoLine(Lotto lotto) {
        return lotto.getNumbers().toString();
    }

    static String toPrizeLine(Prize prize, int count) {
        return prize.getCount() + "개 일치 (" + prize.getMoney() + "원)- " + count + "개";
    }

    static String toProfitRateMessage(double rate) {
        String message = "총 수익률은 " + rate + "입니다.";
        if (rate < BREAK_EVEN) {
            return message + LOSS_NOTICE;
        }
        return message;
    }
}
