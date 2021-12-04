package step2.controller;

import step2.domain.*;
import step2.dto.WinningInformation;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoController {
    public Lotto buyAndPrintLotto(){
        String purchaseAmount = InputView.purchaseAmount();
        Lotto lotto = LottoFactory.buyWithMoney(purchaseAmount);
        OutputView.printNumberOfPurchase(lotto.size());
        List<LottoNumbers> lottoNumbersList = lotto.getLottoNumbersList();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            OutputView.printLottoNumbers(lottoNumbers.getLottoNumbers());

        }
        return lotto;
    }
    public void winningInformationOf(Lotto lotto){
        String winningLotteryNumbers = InputView.winningLotteryNumbers();
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(winningLotteryNumbers);
        Map<Integer, Integer> countNumberOfMatching = lotto.countNumberOfMatching(lottoWinningNumbers);
        LottoWinningRules lottoWinningRules = lotto.getLottoWinningRules();
        Set<Integer> num = lottoWinningRules.numberOfMatching();
        List<WinningInformation> winningInformation = new ArrayList<>();
        for (Integer integer : num) {
            int numberOfMatching = integer;
            int prizeMoney = lottoWinningRules.getPrizeOf(numberOfMatching);
            int numberOfWinning = countNumberOfMatching.getOrDefault(numberOfMatching, 0);
            winningInformation.add(new WinningInformation(numberOfMatching, prizeMoney, numberOfWinning));
        }
        OutputView.printWinningStatics(winningInformation);
        int earningRate = lotto.earningRate(countNumberOfMatching);
        OutputView.earningRate(earningRate);
    }
}
