package lottoView;

import lottoModel.Lotto;
import lottoController.LottoDomain;
import lottoModel.LottoResult;

import java.util.List;

public class ResultView {

    public static void resultCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(LottoDomain.sortLottoNumber(lotto.getNumbers()).toString());
        }
    }

    public static void printLottoResult(LottoResult lottoResult) {

        String rateOfReturnMessage = "입니다.(기준이 0이기 때문에 결과적으로 손해라는 의미임)";
        if (lottoResult.getRateOfReturn() == 0) {
            rateOfReturnMessage = "입니다.(기준이 0이기 때문에 결과적으로 본전임)";
        }
        if (lottoResult.getRateOfReturn() > 0) {
            rateOfReturnMessage = "입니다.(기준이 0이기 때문에 결과적으로 수익이라는 의미임)";
        }
        String result = "당첨 통계" + "\n" +
                "---------" + "\n" +
                "3개 일치 (5000원)- " + lottoResult.getTree() + "\n" +
                "4개 일치 (50000원)- " + lottoResult.getFour() + "\n" +
                "5개 일치 (1500000원)- " + lottoResult.getFive() + "\n" +
                "6개 일치 (2000000000)- " + lottoResult.getSix() + "\n" +
                "총 수익률은 " + lottoResult.getRateOfReturn() +
                rateOfReturnMessage;

        System.out.println(result);

    }

}
