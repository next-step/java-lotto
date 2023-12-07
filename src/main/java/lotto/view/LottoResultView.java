package lotto.view;

import lotto.domain.LottoBuyInfo;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class LottoResultView {
    private static final String INFORMATION_INPUT_COUNT = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String NOTICE_WINNING_RATE = "\n당첨 통계\n-----";
    private static final String NOTICE_LOTTO_RATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String RESULT_MATCH_COUNT = "개 일치";
    private static final String RESULT_BONUS = ", 보너스 볼 일치";
    private static final String RESULT_COUNT = "개";

    public static StringBuilder BUILDER;

    public static void showLottos(LottoBuyInfo buyInfo, Lottos lottos) {
        System.out.println(String.format(INFORMATION_INPUT_COUNT, buyInfo.getManualCount(), buyInfo.getAutoCount()));
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
        BUILDER = new StringBuilder();
        if (prize.equals(LottoPrize.NONE)) {
            return;
        }
        BUILDER.append(prize.getMatchCount() + RESULT_MATCH_COUNT);
        if (prize.equals(LottoPrize.SECOND)) {
            BUILDER.append(RESULT_BONUS);
        }
        BUILDER.append(" (" + prize.getPrize() + ")- ");
        BUILDER.append(count + RESULT_COUNT);
        System.out.println(BUILDER.toString());
    }

    public static void shotRate(double rate) {
        System.out.println(String.format(NOTICE_LOTTO_RATE, rate, getRateInfo(rate)));
    }

    private static String getRateInfo(double rate) {
        double baseRate = 1.0;
        if (rate > baseRate) {
            return "이득이";
        }
        if (rate == baseRate) {
            return "본전이";
        }
        return "손해";
    }
}
