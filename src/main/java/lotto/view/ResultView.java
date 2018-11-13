package lotto.view;

import lotto.LottoGame;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Reward;

import java.util.List;

public abstract class ResultView {

    private final static String COUNT_OF_PURCHASES_SUFFIX = "개를 구매했습니다.";

    private ResultView() {
    }

    public static void printLottos(final LottoGame lottoGame) {
        printCountOfPurchases(lottoGame.getCountPurchased());
        printLottos(lottoGame.getLottos());
        newLine();
    }

    @SuppressWarnings("CodeBlock2Expr")
    public static void printAnalysisLottoResult(final LottoGame lottoGame, final Lotto lotto, final int amount) {
        final StringBuilder sb = new StringBuilder();

        sb.append("\n당첨 통계\n").append("---------\n");

        Reward.NUMBERS.forEach(reward -> {
            sb.append(reward.getMatchNumber());
            sb.append("개 일치 (");
            sb.append(reward.getPrice());
            sb.append(")- ");
            sb.append(Lottos.filter(lottoGame.getLottos(), lotto.getNumber(), reward.getMatchNumber()).size());
            sb.append("개\n");
        });

        sb.append("총 수익률은 ");
        sb.append(Lottos.getRate(lottoGame.getLottos(), lotto.getNumber(), amount));
        sb.append("입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");

        System.out.println(sb.toString());
    }

    private static void printCountOfPurchases(final int countPurchased) {
        System.out.println(countPurchased + COUNT_OF_PURCHASES_SUFFIX);
    }

    private static void printLottos(final List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    private static void newLine() {
        System.out.println();
    }

}
