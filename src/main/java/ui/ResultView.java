package ui;

import domain.*;

public class ResultView {
    private static final String BUYING_AMOUNT_IS = "개를 구매했습니다.";
    private static final String LOTTO_STATISTICS_IS = "당첨 통계\n---------";
    private static final String FOURTH_PRIZE_IS = "3개 일치 (%d원)- ";
    private static final String THIRD_PRIZE_IS = "4개 일치 (%d원)- ";
    private static final String SECOND_PRIZE_IS = "5개 일치 (%d원)- ";
    private static final String FIRST_PRIZE_IS = "6개 일치 (%d원)- ";
    private static final String TOTAL_MARGIN_RATES_ARE = "총 수익률은 %.2f입니다.";

    public static void printBuyingLottos(Lottos lottos) {
        System.out.print(lottos.size());
        System.out.println(BUYING_AMOUNT_IS);

        lottos.stream().forEach(System.out::println);
    }

    public static void printLottoResult(LottoResult lottoResult) throws Exception {
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        System.out.println(LOTTO_STATISTICS_IS);
        System.out.printf(FOURTH_PRIZE_IS, LottoPrize.FOURTH_PRIZE.getPrizeValue());
        System.out.println(lottoPrizeCount.getPrizeCount(LottoPrize.FOURTH_PRIZE));
        System.out.printf(THIRD_PRIZE_IS, LottoPrize.THIRD_PRIZE.getPrizeValue());
        System.out.println(lottoPrizeCount.getPrizeCount(LottoPrize.THIRD_PRIZE));
        System.out.printf(SECOND_PRIZE_IS, LottoPrize.SECOND_PRIZE.getPrizeValue());
        System.out.println(lottoPrizeCount.getPrizeCount(LottoPrize.SECOND_PRIZE));
        System.out.printf(FIRST_PRIZE_IS, LottoPrize.FIRST_PRIZE.getPrizeValue());
        System.out.println(lottoPrizeCount.getPrizeCount(LottoPrize.FIRST_PRIZE));
        System.out.printf(TOTAL_MARGIN_RATES_ARE, lottoResult.calculateProfitRates());
    }
}
