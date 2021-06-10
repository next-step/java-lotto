package kr.aterilio.nextstep.techcamp.m1.lotto.view;

import kr.aterilio.nextstep.techcamp.m1.lotto.LottoBundle;
import kr.aterilio.nextstep.techcamp.m1.lotto.result.LottoResult;
import kr.aterilio.nextstep.techcamp.m1.utils.StringUtil;

public class ResultView {

    private static final int UNIT_POINT_POSITION = 2;
    private static final int RATE_PRINCIPAL = 1;
    private static final String MSG_LOSS_PRINCIPAL = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void printBundle(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.count() + "개를 구매했습니다.");
        if (!lottoBundle.empty()) {
            System.out.println(lottoBundle.join());
        }
    }

    public void printResult(LottoResult lottoResult) {
        float rateOfReturn = lottoResult.rateOfReturn();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResult.detail());
        System.out.printf("총 수익률은 %s 입니다. %s\n", rateToString(rateOfReturn), rateDesc(rateOfReturn));
    }

    private String rateToString(float rate) {
        return StringUtil.floorFloatWithPointPosition(
                rate, UNIT_POINT_POSITION
        );
    }

    private String rateDesc(float rateOfReturn) {
        if (rateOfReturn < RATE_PRINCIPAL) {
            return MSG_LOSS_PRINCIPAL;
        }
        return StringUtil.EMPTY_STRING;
    }
}
