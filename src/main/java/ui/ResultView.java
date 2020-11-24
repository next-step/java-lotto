package ui;

import domain.*;

import static domain.LottoPrize.*;

public class ResultView {
    private static final String MANUAL_LOTTO_AMOUNT_IS = "수동으로 %d장, ";
    private static final String AUTO_LOTTO_AMOUNT_IS = "자동으로 %d개를 구매했습니다.\n";
    private static final String LOTTO_STATISTICS_IS = "당첨 통계\n---------";
    private static final String FIFTH_PRIZE_IS = "3개 일치 (%d원)- ";
    private static final String FOURTH_PRIZE_IS = "4개 일치 (%d원)- ";
    private static final String THIRD_PRIZE_IS = "5개 일치 (%d원)- ";
    private static final String SECOND_PRIZE_IS = "5개 일치, 보너스 볼 일치(%d원)- ";
    private static final String FIRST_PRIZE_IS = "6개 일치 (%d원)- ";
    private static final String TOTAL_MARGIN_RATES_ARE = "총 수익률은 %.2f입니다.";

    public static void printBuyingLottos(Lottos lottos, int numberOfManualLottos) {
        System.out.printf(MANUAL_LOTTO_AMOUNT_IS, numberOfManualLottos);
        System.out.printf(AUTO_LOTTO_AMOUNT_IS, lottos.size() - numberOfManualLottos);

        lottos.stream().forEach(System.out::println);
    }

    public static void printLottoResult(LottoResult lottoResult) throws Exception {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        System.out.println(LOTTO_STATISTICS_IS);
        System.out.printf(FIFTH_PRIZE_IS, FIFTH_PRIZE.getPrizeValue());
        System.out.println(lottoPrizeCount.getPrizeCount(FIFTH_PRIZE));
        System.out.printf(FOURTH_PRIZE_IS, FOURTH_PRIZE.getPrizeValue());
        System.out.println(lottoPrizeCount.getPrizeCount(FOURTH_PRIZE));
        System.out.printf(THIRD_PRIZE_IS, THIRD_PRIZE.getPrizeValue());
        System.out.println(lottoPrizeCount.getPrizeCount(THIRD_PRIZE));
        System.out.printf(SECOND_PRIZE_IS, SECOND_PRIZE.getPrizeValue());
        System.out.println(lottoPrizeCount.getPrizeCount(SECOND_PRIZE));
        System.out.printf(FIRST_PRIZE_IS, FIRST_PRIZE.getPrizeValue());
        System.out.println(lottoPrizeCount.getPrizeCount(FIRST_PRIZE));
        System.out.printf(TOTAL_MARGIN_RATES_ARE, lottoResult.calculateProfitRates());
    }
}
