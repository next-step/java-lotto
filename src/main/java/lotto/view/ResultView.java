package lotto.view;

import lotto.domain.LottoMatchInformation;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;

public class ResultView {

    private static final int LOTTO_PRICE = 1000;
    private static final String INFORMATION_PURCHASE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String INFORMATION_LOTTO_STATISTICS = "당첨 통계";
    private static final String LOTTO_MATCH_INFORMATION = "%d개 일치 (%d원)- %d개";
    private static final String LOTTO_RATE_INFORMATION = "총 수익률은 %.2f입니다.";
    private static final String LOTTO_LOSS_RATE_INFORMATION = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String LOTTO_PRINCIPAL_RATE_INFORMATION = "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";
    private static final String LOTTO_PROFIT_RATE_INFORMATION = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String BLANK = "";
    private static final String HORIZONTAL_LINE = "----------";

    public int lottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
    public void showLottoCount(int lottoCount) {
        System.out.println(lottoCount + INFORMATION_PURCHASE_LOTTO_COUNT);
        System.out.println(BLANK);
    }

    public void showLottoList(Lottos lottos) {
        for (int i = 0; i< lottos.getSize(); i++) {
            System.out.println(lottos.getLotto(i).getLotto());
        }
    }

    public void showLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println(BLANK);
        System.out.println(INFORMATION_LOTTO_STATISTICS);
        System.out.println(HORIZONTAL_LINE);
        for (LottoMatchInformation matchInformation : lottoStatistics.getInformation().values()) {
            System.out.println(String.format(LOTTO_MATCH_INFORMATION, matchInformation.getMatch(), (int) matchInformation.getPrize(), matchInformation.getCount()));
        }
        double rate = lottoStatistics.getRate();
        System.out.print(String.format(LOTTO_RATE_INFORMATION, rate));
        if (rate < 1) {
            System.out.println(LOTTO_LOSS_RATE_INFORMATION);
            return;
        }
        if (rate == 1) {
            System.out.println(LOTTO_PRINCIPAL_RATE_INFORMATION);
            return;
        }
        System.out.println(LOTTO_PROFIT_RATE_INFORMATION);
    }
}
