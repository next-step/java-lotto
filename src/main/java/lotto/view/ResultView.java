package lotto.view;

import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.lotto.wrapper.LottoNumbers;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.lotto.LotteryRank.*;

public class ResultView {

    public void printPurchaseResult(int numOfLotto, List<LottoNumbers> lottoNumberses) {
        printNumOfLotto(numOfLotto);
        printLottoNumbers(lottoNumberses);
    }

    private void printNumOfLotto(int numOfLotto) {
        System.out.println(numOfLotto + "개를 구매했습니다.");
    }

    private void printLottoNumbers(List<LottoNumbers> lottoNumberses) {
        lottoNumberses.forEach(System.out::println);
    }

    public void printLottoGameResult(RankCountGroup rankCountGroup, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        printNumOfMatching(rankCountGroup);
        printProfitRate(profitRate);
    }

    private void printNumOfMatching(RankCountGroup rankCountGroup) {
        Arrays.stream(values())
            .forEach(rank -> {
                long winningCount = rankCountGroup.findWinningCountBy(rank);
                System.out.println(rank.matchingCount() + "개 일치 (" + rank.prize() + "원) - " + winningCount + "개");
            });
    }

    private void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}
