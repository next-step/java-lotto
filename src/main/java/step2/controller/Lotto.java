package step2.controller;

import step2.domain.LottoCalculator;
import step2.domain.LottoGenerator;
import step2.domain.LottoNumber;
import step2.domain.LottoParser;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.*;

public class Lotto {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        ResultView.printNumOfLotto(LottoCalculator.getCountOfLotto(purchaseAmount));

        List<LottoNumber> lottoNumbers = LottoGenerator.generateTotalLotto(LottoCalculator.getCountOfLotto(purchaseAmount));
        ResultView.printLottos(lottoNumbers);

        LottoNumber winningNumbers = LottoParser.parseWinningNumbers(InputView.getWinningNumbers());

        double profitRate = LottoCalculator.getTotalProfit(lottoNumbers, winningNumbers, purchaseAmount);

        String winningStatistics = ResultView.displayWinningStatistics(lottoNumbers, winningNumbers, profitRate);
        System.out.println(winningStatistics);

    }

}
