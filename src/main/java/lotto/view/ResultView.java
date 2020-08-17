package lotto.view;

import lotto.domain.*;

public class ResultView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String HEAD_STATISTICS_MESSAGE = String.format("%s당첨 통계%s---------", LINE_SEPARATOR, LINE_SEPARATOR);
    private static final String RANKING_STATISTICS_MESSAGE = String.format("%%s개 일치 (%%s원) - %%s개%s", LINE_SEPARATOR);
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.2f 입니다.";
    private static final String LOSS_NOTICE_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private ResultView() {}

    public static void displayLottoCount(Money money) {
        System.out.println(String.format(PURCHASE_COUNT_MESSAGE, money.getLottoCount()));
    }

    public static void displayLottos(Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos.getLottos()) {
            stringBuilder.append(lotto.toString()).append(LINE_SEPARATOR);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void displayLottoResult(LottoResult lottoResult, Money money) {
        System.out.println(HEAD_STATISTICS_MESSAGE);

        StringBuilder stringBuilder = new StringBuilder();
        for (Ranking ranking : lottoResult.getLottoResultMap().keySet()) {
            stringBuilder.append(String.format(RANKING_STATISTICS_MESSAGE, ranking.getCountOfMatch(),
                    ranking.getPrizeMoney(), lottoResult.getLottoResultMap().get(ranking)));
        }

        double profitRate = lottoResult.findProfitRate(money);
        stringBuilder.append(String.format(TOTAL_PROFIT_MESSAGE, profitRate));

        if (profitRate < 1) {
            stringBuilder.append(LOSS_NOTICE_MESSAGE);
        }

        System.out.println(stringBuilder.toString());
    }
}
