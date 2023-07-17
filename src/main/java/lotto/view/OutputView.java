package lotto.view;

import lotto.model.*;

import java.util.Comparator;
import java.util.List;
import lotto.model.dto.LottosDto;
import lotto.model.dto.WinningResultDto;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

public class OutputView {

    private static final String DELIMITER = ", ";

    public static void printPurchasedResult(final LottosDto purChasedLotto) {
        System.out.println(purChasedLotto.getLottoCount() + "개를 구매했습니다");
        for (Lotto lotto : purChasedLotto.getLottos()) {
            printLotto(lotto);
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

    public static void printWinningResult(final WinningResultDto winningResultDto) {
        System.out.println("당첨 통계\n---------");
        for (var rank : winningResultDto.getRanks()) {
            printRank(rank, winningResultDto.getCount(rank));
        }
        printProfit(winningResultDto);
    }

    private static void printProfit(final WinningResultDto winningResultDto) {
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",
            winningResultDto.floorProfit());
    }

    private static void printRank(final Rank rank, final int rankCount) {
        System.out.println(
            rank.getMatch() + "개 일치" + needBonus(rank) +
                " (" + rank.getReward() + "원)"
                + "- " + rankCount + "개");
    }

    private static String needBonus(final Rank rank) {
        if (rank != Rank.FIVE_WITH_BONUS) {
            return " ";
        }
        return ", 보너스 볼 일치";
    }
}
