package lotto.view;

import lotto.model.*;

import java.util.Comparator;
import java.util.List;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

public class OutputView {

    private static final String DELIMITER = ", ";

    public static void printPurchasedResult(PurChasedLotto purChasedLotto) {
        System.out.println(purChasedLotto.getLottoCount() + "개를 구매했습니다");
        for (Lotto lotto : purChasedLotto.getLottos()) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getNumber));
        System.out.println("[" + lottoNumberToString(lottoNumbers) + "]");
    }

    private static String lottoNumberToString(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(lottoNumber -> valueOf(lottoNumber.getNumber()))
                .collect(joining(DELIMITER));
    }

    public static void printWinningResult(WinningResponse winningResponse) {
        System.out.println("당첨 통계\n---------");
        for (var rank : winningResponse.getRanks()) {
            printRank(rank, winningResponse.getCount(rank));
        }
        printProfit(winningResponse);
    }

    private static void printProfit(WinningResponse winningResponse) {
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", winningResponse.calculateProfit());
    }

    private static void printRank(Rank rank, int rankCount) {
        System.out.println(
                rank.getMatch() + "개 일치" + needBonus(rank) +
                        " (" + rank.getReward() + "원)"
                        + "- " + rankCount + "개");
    }

    private static String needBonus(Rank rank) {
        if (rank != Rank.FIVE_WITH_BONUS) return " ";
        return ", 보너스 볼 일치";
    }
}
