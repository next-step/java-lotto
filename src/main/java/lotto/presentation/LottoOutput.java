package lotto.presentation;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoOutput {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    /**
     * 구매한 로또 번호 출력
     *
     * @param lottos
     * @param money
     */
    public void printPurchasedLottos(Lottos lottos, Money money) {
        StringBuilder sb = new StringBuilder();
        sb.append(money.getLottoCount()).append("개를 구매했습니다.").append(System.lineSeparator());
        for (Lotto lotto : lottos.getLottos()) {
            sb.append(lotto.toString()).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public void printWinningStatistics(LottoWallet lottoWallet) {
        Map<LottoResult, Integer> lottoResultCounts = lottoWallet.getLottoResultCounts();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.getMatchCount() != 0)
                .map(lottoResult -> lottoResult.getMatchCount() + "개 일치 (" + lottoResult.getReward() + "원)- " +
                        lottoResultCounts.get(lottoResult) + "개")
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + DECIMAL_FORMAT.format(profitRate) +
                "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

}
