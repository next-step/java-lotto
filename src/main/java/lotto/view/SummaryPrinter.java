package lotto.view;

import lotto.domain.PrizeCalculator;
import lotto.domain.Rank;
import lotto.domain.Winners;

import java.text.DecimalFormat;

public class SummaryPrinter {

    public static void summary(final Winners winners){

        System.out.println("당첨 통계");
        System.out.println("==================");

        for(Rank rank : Rank.values()){

            String printStr = String.format("%s개 일치(%s)-%s개", rank.getCountOfMatch(), new DecimalFormat("0").format(rank.getWinningMoney()), winners.getWinnersCount(rank));
            System.out.println(printStr);

        }
        System.out.println(String.format("총 수익률은 %s 입니다.", new DecimalFormat("0.00").format(PrizeCalculator.rateOfPrize(winners))));
    }
}
