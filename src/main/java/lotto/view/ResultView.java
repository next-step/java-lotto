package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Statistics;
import lotto.domain.WinnigResult;

import java.util.List;

public class ResultView {

    public static final String FIRST_MSG = "6개 일치 (" + WinnigResult.FIRST_EARN_MONEY + "원) -";
    public static final String SECOND_MSG = "5개 일치 (" + WinnigResult.SECOND_EARN_MONEY + "원) -";
    public static final String THIRD_MSG = "4개 일치 (" + WinnigResult.THIRD_EARN_MONEY + "원) -";
    public static final String FOURTH_MSG = "3개 일치 (" + WinnigResult.FOURTH_EARN_MONEY + "원) -";

    public void lottoNumberView(List<LottoNumber> lottos) {
        for (LottoNumber lottoNumber : lottos) {
            System.out.println(lottoNumber.getLotto());
        }
    }

    public void winningResult(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (String status : WinnigResult.winStatus) {
            resultMsg(status, statistics.winningCount(status));
        }
        System.out.println("총 수익률은 " + String.format("%.2f", statistics.getEarnMoneyPercentage()) + " 입니다.");
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
