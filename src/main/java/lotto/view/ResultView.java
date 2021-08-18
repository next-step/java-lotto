package lotto.view;

import lotto.domain.LottoPaper;
import lotto.domain.Statistics;
import lotto.domain.WinnigResult;

import java.util.List;

public class ResultView {

    public static final String FIRST_MSG = "6개 일치 (" + WinnigResult.FIRST_EARN_MONEY + "원) -";
    public static final String SECOND_MSG = "5개 일치 (" + WinnigResult.SECOND_EARN_MONEY + "원) -";
    public static final String THIRD_MSG = "4개 일치 (" + WinnigResult.THIRD_EARN_MONEY + "원) -";
    public static final String FOURTH_MSG = "3개 일치 (" + WinnigResult.FOURTH_EARN_MONEY + "원) -";

    public void lottoNumberView(List<LottoPaper> lottos) {
        for (LottoPaper lottoPaper : lottos) {
            System.out.println(lottoPaper.getLottoNumber());
        }
    }

    public void winningResult(Statistics statistics, int buyMoney) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (String status : WinnigResult.winStatus) {
            resultMsg(status, statistics.winningCount(status));
        }
        double earnRate = (double) statistics.getEarnMoney() / buyMoney;
        System.out.println("총 수익률은 " + String.format("%.2f", earnRate) + " 입니다.");
    }

    private void resultMsg(String status, int count) {

        if (status.equals(WinnigResult.FIRST)) {
            System.out.println(FIRST_MSG + count + "개");
        }
        if (status.equals(WinnigResult.SECOND)) {
            System.out.println(SECOND_MSG + count + "개");
        }
        if (status.equals(WinnigResult.THIRD)) {
            System.out.println(THIRD_MSG + count + "개");
        }
        if (status.equals(WinnigResult.FOURTH)) {
            System.out.println(FOURTH_MSG + count + "개");
        }


    }

}
