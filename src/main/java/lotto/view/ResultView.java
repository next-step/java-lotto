package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.object.Lotto;
import lotto.vo.LottoResult;

public class ResultView {

    private static final String TEXT_EARNINGS_RATE_PROFIT = "기준이 1이기 때문에 결과적으로 이득이라는 의미임";
    private static final String TEXT_EARNINGS_RATE_LOSS = "기준이 1이기 때문에 결과적으로 손해라는 의미임";

    public void printLottoGame(final LottoGame lottoGame) {

        final int count = lottoGame.getCount();

        System.out.println(getPurchaseCountString(count));
        if (count > 0) {
            System.out.println(lottoGame.toString());
        }
        System.out.println();
    }

    private String getPurchaseCountString(final int count) {

        if (count < 1) {
            return "구입 금액 부족으로 로또를 구매하지 못했습니다.";
        }

        return count + "개를 구매했습니다.";
    }

    public void printLottoResult(final LottoGame lottoGame, final Lotto luckyNumbers) {

        final LottoResult lottoResult = lottoGame.getResult(luckyNumbers);
        final float earningsRate = lottoGame.getEarningsRate(lottoResult.getPrize());

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResult.toString());
        System.out.println(getEarningsRateString(earningsRate));
    }

    private String getEarningsRateString(final float earningsRate) {
        return String.format("총 수익률은 %.2f입니다. (%s)"
                , earningsRate
                , earningsRate > 1.f ? TEXT_EARNINGS_RATE_PROFIT : TEXT_EARNINGS_RATE_LOSS
        );
    }
}
