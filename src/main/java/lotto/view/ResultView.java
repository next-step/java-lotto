package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Statistics;
import lotto.domain.WinningLotto;

import java.util.List;

public class ResultView {

    public static final String FIRST_MSG = "6개 일치 (" + WinningLotto.FIRST_EARN_MONEY + "원) -";
    public static final String SECOND_MSG = "5개 일치 (" + WinningLotto.SECOND_EARN_MONEY + "원) -";
    public static final String THIRD_MSG = "4개 일치 (" + WinningLotto.THIRD_EARN_MONEY + "원) -";
    public static final String FOURTH_MSG = "3개 일치 (" + WinningLotto.FOURTH_EARN_MONEY + "원) -";

    public void lottoNumberView(List<LottoNumber> lottos) {
        for (LottoNumber lottoNumber : lottos) {
            System.out.println(lottoNumber.getLotto());
        }
    }

    public void winningResult(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (String status : WinningLotto.winStatus) {
            resultMsg(status, statistics.winningCount(status));
        }
        System.out.println("총 수익률은 " + String.format("%.2f", statistics.getEarnMoneyPercentage()) + " 입니다.");
    }

    private void resultMsg(String status, int count) {

        if (status.equals(WinningLotto.FIRST)) {
            System.out.println(FIRST_MSG + count + "개");
        }
        if (status.equals(WinningLotto.SECOND)) {
            System.out.println(SECOND_MSG + count + "개");
        }
        if (status.equals(WinningLotto.THIRD)) {
            System.out.println(THIRD_MSG + count + "개");
        }
        if (status.equals(WinningLotto.FOURTH)) {
            System.out.println(FOURTH_MSG + count + "개");
        }


    }

}
