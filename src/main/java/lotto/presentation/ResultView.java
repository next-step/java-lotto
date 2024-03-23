package lotto.presentation;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningRank;
import lotto.domain.UserLottoResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printPurchaseCount(int count) {
        System.out.printf("%d개를 구매했습니다.", count);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            String lottoString = lotto.getLottoNumbers().stream()
                    .map(number -> Integer.toString(number))
                    .collect(Collectors.joining(", "));

            System.out.println("[" + lottoString + "]");
        }
        System.out.println();
    }

    public void printLottoResult(UserLottoResult userLottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoWinningRank.values())
                .map(lottoWinningRank -> makeStringForWinningLottoRank(lottoWinningRank) + makeStringForUserLottoResult(lottoWinningRank,userLottoResult))
                .forEach(System.out::println);

        System.out.printf("총 수익률은 %.2f\n", userLottoResult.getRateOfReturn());
    }

    private String makeStringForWinningLottoRank(LottoWinningRank lottoWinningRank) {
        String countMatch = "%d개 일치";
        String winningPrice = "(%d원)- ";
        String printingMatchCount;

        printingMatchCount =  String.format(countMatch + " ", lottoWinningRank.getMatchCount());

        if (lottoWinningRank.getRequireMatchBonus()) {
            printingMatchCount += ", 보너스볼 일치 ";
        }

        return String.format(printingMatchCount + winningPrice, lottoWinningRank.getWinningPrice());
    }

    private String makeStringForUserLottoResult(LottoWinningRank lottoWinningRank, UserLottoResult userLottoResult) {
        String winningRankCount = "%d개";

        return String.format(winningRankCount, userLottoResult.getCountLottoResult(lottoWinningRank));
    }


}
