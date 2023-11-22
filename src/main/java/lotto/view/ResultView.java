package lotto.view;

import lotto.domain.LottoMatchInformation;
import lotto.domain.LottoMatchNumbers;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;

import java.util.Map;

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
    private static final String NEXT_LINE = "\n";
    private static final String HORIZONTAL_LINE = "----------";
    private static final int RATE_CRITERIA = 1;

    private ResultView(){}

    public static void showLottoCount(int purchaseCount) {
        System.out.println(purchaseCount + INFORMATION_PURCHASE_LOTTO_COUNT);
        System.out.println(BLANK);
    }

    public static void showLottoList(Lottos lottoList) {
        for (int i = 0; i< lottoList.getSize(); i++) {
            System.out.println(lottoList.getLotto(i).getNumbers());
        }
    }

    private static StringBuilder getInformationStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(NEXT_LINE);
        sb.append(INFORMATION_LOTTO_STATISTICS);
        sb.append(NEXT_LINE);
        sb.append(HORIZONTAL_LINE);
        return sb;
    }

    public static void showLottoStatistics(LottoMatchNumbers lottoMatchNumbers, LottoStatistics lottoStatistics) {
        System.out.println(getInformationStatistics());
        Map<Integer, Integer> matchNumberMap = lottoMatchNumbers.getMatchNumberMap();
        for (Integer key : matchNumberMap.keySet()) {
            System.out.println(
                    String.format(
                            LOTTO_MATCH_INFORMATION,
                            lottoStatistics.getInformation().get(key).getMatch(),
                            (int) lottoStatistics.getInformation().get(key).getPrize(),
                            matchNumberMap.get(key)));
        }
    }

    public static void showRate(double rate) {
        System.out.print(String.format(LOTTO_RATE_INFORMATION, rate));
        if (rate > RATE_CRITERIA) {
            System.out.println(LOTTO_PROFIT_RATE_INFORMATION);
            return;
        }
        if (rate == RATE_CRITERIA) {
            System.out.println(LOTTO_PRINCIPAL_RATE_INFORMATION);
            return;
        }
        System.out.println(LOTTO_LOSS_RATE_INFORMATION);
    }
}
