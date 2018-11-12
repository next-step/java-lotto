package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Reward;

import java.util.List;

public abstract class ResultView {

    private final static String COUNT_OF_PURCHASES_SUFFIX = "개를 구매했습니다.";

    private ResultView() {
    }

    public static void printLottos(int countAvailableForPurchase, List<Lotto> lottos) {
        printCountOfPurchases(countAvailableForPurchase);
        printLottos(lottos);
        newLine();
    }

    @SuppressWarnings("CodeBlock2Expr")
    public static void printAnalysisLottoResult(final LottoNumber lottoNumber, final List<Lotto> lottos, final int lottoPurchaseAmount) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n").append("---------\n");
        Reward.NUMBERS.forEach(reward -> {
            sb.append(reward.getMatchNumber()).append("개 일치 (").append(reward.getPrice()).append(")- ").append(Lottos.filter(lottoNumber, lottos, reward.getMatchNumber()).size()).append("개\n");
        });
        sb.append("총 수익률은 ").append(Lottos.getRate(lottoNumber, lottos, lottoPurchaseAmount)).append("입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        System.out.println(sb.toString());
    }

    private static void printCountOfPurchases(final int purchase) {
        System.out.println(purchase + COUNT_OF_PURCHASES_SUFFIX);
    }

    private static void printLottos(final List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumber().toString());
        }
    }

    private static void newLine() {
        System.out.println();
    }

}
