package lotto_step3.view;

import lotto_step3.domain.Lotto;
import lotto_step3.domain.LottoPrize;
import lotto_step3.domain.LottoRate;
import lotto_step3.domain.LottoResult;
import lotto_step3.domain.Lottos;

public class LottoResultView {
    private static final String NOTICE_WINNING_RATE = "\n당첨 통계\n-----";
    private static final String NOTICE_LOTTO_RATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    public static void showLottos(Lottos lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.getLottoNumber(i));
        }
    }

    public static void showResult(LottoResult result) {
        System.out.println(NOTICE_WINNING_RATE);
        for (LottoPrize prize : LottoPrize.values()) {
            showResult(result.countingPrize(prize), prize);
        }
    }

    private static void showResult(int count, LottoPrize prize) {
        if (prize.equals(LottoPrize.NONE)) {
            return;
        }
        System.out.println(prize.toString(count));

    }

    public static void shotRate(double rate) {
        System.out.println(String.format(NOTICE_LOTTO_RATE, rate, LottoRate.getInfo(rate)));
    }
}
