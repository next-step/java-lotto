package lotto.view;

import lotto.model.*;

import java.util.Comparator;
import java.util.List;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

public class OutputView {

    private static final String DELIMITER = ", ";

    public static void printPurchasedLottos(final PurChasedLottos purChasedLottos) {
        System.out.println(purChasedLottos.getLottoCount() + "개를 구매했습니다");
        for (var purchaseLotto : purChasedLottos.getLottos()) {
            printLotto(purchaseLotto);
        }
    }

    private static void printLotto(final Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getNumber));
        System.out.println("[" + lottoNumberToString(lottoNumbers) + "]");
    }

    private static String lottoNumberToString(final List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(lottoNumber -> valueOf(lottoNumber.getNumber()))
                .collect(joining(DELIMITER));
    }

    public static void printWinningResult(final WinningResult winningResult) {
        printWinningHeadLine();
        for (var rank : Rank.values()) {
            printRank(rank, winningResult.getCountOfRank(rank));
        }
        printProfit(winningResult);
    }

    private static void printWinningHeadLine() {
        System.out.println("\n당첨 통계\n---------");
    }

    private static void printRank(final Rank rank, final int rankCount) {
        if (isNotDefault(rank)) {
            System.out.println(rank.getMatch() + "개 일치" + needBonusPhase(rank) +
                    " (" + rank.getReward() + "원)" + "- " + rankCount + "개");
        }
    }

    private static boolean isNotDefault(final Rank rank) {
        return !(rank == Rank.DEFAULT);
    }

    private static void printProfit(final WinningResult winningResult) {
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", winningResult.getProfit());
    }


    private static String needBonusPhase(final Rank rank) {
        if (rank != Rank.FIVE_WITH_BONUS) {
            return " ";
        }
        return ", 보너스 볼 일치";
    }
}
