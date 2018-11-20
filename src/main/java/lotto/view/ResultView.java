package lotto.view;

import lotto.LottoGame;
import lotto.LottoResult;
import lotto.domain.*;

import java.util.List;
import java.util.Map;

public abstract class ResultView {

    private final static String COUNT_OF_PURCHASES_SUFFIX = "개를 구매했습니다.";

    private ResultView() {
    }

    public static void printLottos(final LottoGame lottoGame, final Money money) {
        printCountOfPurchases(money);
        printLottos(lottoGame.getLottos());
        newLine();
    }

    public static void printAnalysisLottoResult(final LottoDto lottoDto, final Money money) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n").append("---------\n");
        appendRanks(lottoDto, sb);
        sb.append("총 수익률은 ");
        sb.append(money.calculateRate(lottoDto));
        sb.append("입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        System.out.println(sb.toString());
    }

    private static void appendRanks(final LottoDto lottoDto, final StringBuilder sb) {
        final Map<Rank, Lottos> rankLottos = LottoResult.calculateLottoResult(lottoDto);
        appendRank(sb, Rank.FIFTH, rankLottos.get(Rank.FIFTH));
        appendRank(sb, Rank.FOURTH, rankLottos.get(Rank.FOURTH));
        appendRank(sb, Rank.THIRD, rankLottos.get(Rank.THIRD));
        appendRank(sb, Rank.SECOND, rankLottos.get(Rank.SECOND));
        appendRank(sb, Rank.FIRST, rankLottos.get(Rank.FIRST));
    }

    private static void appendRank(final StringBuilder sb, final Rank rank, final Lottos lottos) {
        sb.append(rank.getCountOfMatch());
        sb.append(rank.equals(Rank.SECOND) ? "개 일치, 보너스 볼 일치(" : "개 일치 (");
        sb.append(rank.getWinningMoney());
        sb.append(")- ");
        sb.append(Lottos.rankOfMatchSize(lottos));
        sb.append("개\n");
    }

    private static void printCountOfPurchases(final Money money) {

        if (money.hasManualPurchaseLottoNumber()) {
            System.out.println("수동으로 " + money.getManualPurchaseLottoNumber() + "장, 자동으로 " + money.calculateLottoCountToPurchasedAutomatically() + "개를 구매했습니다.");
            return;
        }

        System.out.println(money.calculateLottoCountToPurchasedAutomatically() + COUNT_OF_PURCHASES_SUFFIX);
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
