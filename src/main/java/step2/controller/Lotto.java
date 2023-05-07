package step2.controller;

import step2.domain.LottoCalculator;
import step2.domain.LottoGenerator;
import step2.domain.LottoParser;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.*;

public class Lotto {
    public static void main(String[] args) {
        // 구입 금액 입력받기
        int purchaseAmount = InputView.getPurchaseAmount();
        ResultView.printNumOfLotto(purchaseAmount);

        // 로또 발급하기
        List<List<Integer>> lottos = LottoGenerator.generateTotalLotto(LottoCalculator.getCountOfLotto(purchaseAmount));
        ResultView.printLottos(lottos);

        // 지난 주 당첨 번호 입력받기
        List<Integer> winningNumbers = LottoParser.parseWinningNumbers(InputView.getWinningNumbers());

        // 로또 당첨 금액 계산하기
        double profitRate = LottoCalculator.getTotalProfit(lottos, winningNumbers, purchaseAmount);

        String winningStatistics = ResultView.displayWinningStatistics(lottos, winningNumbers, profitRate);
        System.out.println(winningStatistics);

    }

}
