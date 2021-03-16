package lotto.view;

import lotto.domain.LottoList;
import lotto.domain.LottoStatistics;

public class ResultView {
    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoList(LottoList lottoList) {
        System.out.println(lottoList.toString());
    }

    public void printLottoStatics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println(lottoStatistics.toString());
    }

    public void printLottoEarningRate(double earningRate, boolean isBenefit) {
        String isBenefitOrLoss = (isBenefit) ? "이득" : "손해";
        System.out.println("총 수익률은 " + earningRate
                + "입니다.(기준이 1이기 때문에 결과적으로 " + isBenefitOrLoss +"란 얘기임)");
    }

}
