package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.lotto.LotteryRank;
import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.wrapper.Numbers;
import lotto.util.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.lotto.LotteryRank.*;

public class ResultView {

    private LottoGame lottoGame;

    public ResultView(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public void printPurchaseResult(int numOfLotto) {
        List<Numbers> numberses = printResult(numOfLotto);
        lottoGame.createLottos(numberses);
    }

    private List<Numbers> printResult(int numOfLotto) {
        printNumOfLotto(numOfLotto);

        return printLottoNumbers(numOfLotto);
    }

    private void printNumOfLotto(int numOfLotto) {
        System.out.println(numOfLotto + "개를 구매했습니다.");
    }

    private List<Numbers> printLottoNumbers(int numOfLotto) {
        List<Numbers> numberses = new ArrayList<>();

        IntStream.range(0, numOfLotto)
            .forEach(i -> {
                Numbers numbers = LottoNumber.drawLottoNumbers();
                numberses.add(numbers);
                System.out.println("[" + numbers.toString() + "]");
            });

        return numberses;
    }

    public void printLottoGameResult(Numbers winningNumbers) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        RankCountGroup rankCountGroup = lottoGame.groupByRankCount(winningNumbers);

        printNumOfMatching(rankCountGroup);
        printProfitRate(rankCountGroup);
    }

    private void printNumOfMatching(RankCountGroup rankCountGroup) {
        Arrays.stream(values())
            .forEach(rank -> {
                long winningCount = rankCountGroup.findWinningCountBy(rank);
                System.out.println(rank.matchingCount() + "개 일치 (" + rank.prize() + "원) - " + winningCount + "개");
            });
    }

    private void printProfitRate(RankCountGroup rankCountGroup) {
        double profitRate = lottoGame.calculateProfitRate(rankCountGroup);
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}
