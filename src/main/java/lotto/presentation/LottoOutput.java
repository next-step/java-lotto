package lotto.presentation;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 출력 객체
 */
public final class LottoOutput {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    /**
     * 구매한 로또 번호 출력
     *
     * @param lottos
     * @param manualPurchaseInformation
     */
    public void printPurchasedLottos(final Lottos lottos, final PurchaseInformation manualPurchaseInformation) {
        final StringBuilder sb = new StringBuilder();
        final int manualLottoCount = manualPurchaseInformation.getLottoCount();
        sb.append("수동으로 ");
        sb.append(manualLottoCount).append("장, 자동으로 ");
        sb.append(lottos.size() - manualLottoCount).append("개를 구매했습니다.").append(System.lineSeparator());
        for (final Lotto lotto : lottos.getLottos()) {
            sb.append(lotto.toString()).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    /**
     * 당첨 통계 출력
     *
     * @param winningResult
     */
    public void printWinningStatistics(final WinningResult winningResult) {
        final Map<LottoResult, Integer> lottoResultCounts = winningResult.getLottoResultCounts();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.getMatchCount() != 0)
                .map(lottoResult -> {
                    if (lottoResult == LottoResult.SECOND) {
                        return lottoResult.getMatchCount() + "개 일치, 보너스 볼 일치(30000000원) - " +
                                lottoResultCounts.get(lottoResult) + "개";
                    }
                    return lottoResult.getMatchCount() + "개 일치 (" + lottoResult.getReward() + "원)- " +
                            lottoResultCounts.get(lottoResult) + "개";
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 총 수익률 출력
     *
     * @param profitRate
     */
    public void printProfitRate(final double profitRate) {
        System.out.print("총 수익률은 " + DECIMAL_FORMAT.format(profitRate));
        if (profitRate > 1) {
            System.out.println("입니다.(자.. 지금 당장 조용히 복권을 사러가세요... 축하드립니다...)");
            return;
        }
        System.out.println("입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

}
