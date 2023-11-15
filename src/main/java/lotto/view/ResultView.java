package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.lotto.wrapper.LottoNumbers;
import lotto.util.LottoMachine;

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
        List<LottoNumbers> lottoNumberses = printResult(numOfLotto);
        lottoGame.createLottos(lottoNumberses);
    }

    private List<LottoNumbers> printResult(int numOfLotto) {
        List<LottoNumbers> lottoNumberses = drawLottoNumberses(numOfLotto);

        printNumOfLotto(numOfLotto);
        printLottoNumbers(lottoNumberses);

        return lottoNumberses;
    }

    private void printNumOfLotto(int numOfLotto) {
        System.out.println(numOfLotto + "개를 구매했습니다.");
    }

    private List<LottoNumbers> drawLottoNumberses(int numOfLotto) {
        List<LottoNumbers> lottoNumberses = new ArrayList<>();

        IntStream.range(0, numOfLotto)
            .forEach(i -> {
                LottoNumbers lottoNumbers = LottoMachine.drawLottoNumbers();
                lottoNumberses.add(lottoNumbers);
            });

        return lottoNumberses;
    }

    private void printLottoNumbers(List<LottoNumbers> lottoNumberses) {
        lottoNumberses.forEach(System.out::println);
    }

    public void printLottoGameResult(LottoNumbers winningNumbers) {
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
