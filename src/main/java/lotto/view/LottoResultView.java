package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.LottoRate;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class LottoResultView {
    private static final String NOTICE_WINNING_RATE = "\n당첨 통계\n-----";
    private static final String NOTICE_LOTTO_RATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String RESULT_MATCH_COUNT = "개 일치";
    private static final String RESULT_BONUS = ", 보너스 볼 일치";
    private static final String RESULT_COUNT = "개";

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
        StringBuilder builder = new StringBuilder();
        builder.append(prize.getMatchCount() + RESULT_MATCH_COUNT);
        if (prize.equals(LottoPrize.SECOND)) {
            builder.append(RESULT_BONUS);
        }
        builder.append(" (" + prize.getPrize() + ")- ");
        builder.append(count + RESULT_COUNT);
        System.out.println(builder.toString());

    }

    public static void shotRate(double rate) {
        System.out.println(String.format(NOTICE_LOTTO_RATE, rate, LottoRate.getInfo(rate)));
    }
}
