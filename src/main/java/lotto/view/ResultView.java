package lotto.view;

import lotto.LottoGame;
import lotto.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.LottoDto;
import lotto.domain.Rank;

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

    public static void printAnalysisLottoResult(final LottoDto lottoDto, final int amount) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n").append("---------\n");

        sb.append(Rank.FIFTH.getCountOfMatch());
        sb.append("개 일치 (");
        sb.append(Rank.FIFTH.getWinningMoney());
        sb.append(")- ");
        sb.append(LottoResult.rankOfMatch(lottoDto, Rank.FIFTH).getLottos().size());
        sb.append("개\n");

        sb.append(Rank.FOURTH.getCountOfMatch());
        sb.append("개 일치 (");
        sb.append(Rank.FOURTH.getWinningMoney());
        sb.append(")- ");
        sb.append(LottoResult.rankOfMatch(lottoDto, Rank.FOURTH).getLottos().size());
        sb.append("개\n");

        sb.append(Rank.THIRD.getCountOfMatch());
        sb.append("개 일치 (");
        sb.append(Rank.THIRD.getWinningMoney());
        sb.append(")- ");
        sb.append(LottoResult.rankOfMatch(lottoDto, Rank.THIRD).getLottos().size());
        sb.append("개\n");

        sb.append(Rank.SECOND.getCountOfMatch());
        sb.append("개 일치, 보너스 볼 일치");
        sb.append(Rank.SECOND.getWinningMoney());
        sb.append(")- ");
        sb.append(LottoResult.rankOfMatch(lottoDto, Rank.SECOND).getLottos().size());
        sb.append("개\n");

        sb.append(Rank.FIRST.getCountOfMatch());
        sb.append("개 일치 (");
        sb.append(Rank.FIRST.getWinningMoney());
        sb.append(")- ");
        sb.append(LottoResult.rankOfMatch(lottoDto, Rank.FIRST).getLottos().size());
        sb.append("개\n");

        sb.append("총 수익률은 ");
        sb.append(LottoResult.calculatorRate(lottoDto, amount));
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
