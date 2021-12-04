package step2.controller;

import step2.domain.*;
import step2.dto.WinningInformationDto;
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
        List<WinningInformationDto> winningInformationDtoList = winningInformationList(countNumberOfMatching, lottoWinningRules);
        OutputView.printWinningStatics(winningInformationDtoList);
        int earningRate = lotto.earningRate(countNumberOfMatching);
        OutputView.earningRate(earningRate);
    }

    private List<WinningInformationDto> winningInformationList(Map<Integer, Integer> countNumberOfMatching, LottoWinningRules lottoWinningRules) {
        Set<Integer> numberOfMatchingSet = lottoWinningRules.numberOfMatchingSet();
        List<WinningInformationDto> winningInformationDto = new ArrayList<>();
        for (int numberOfMatching : numberOfMatchingSet) {
            int prizeMoney = lottoWinningRules.getPrizeOf(numberOfMatching);
            int numberOfWinning = countNumberOfMatching.getOrDefault(numberOfMatching, 0);
            winningInformationDto.add(new WinningInformationDto(numberOfMatching, prizeMoney, numberOfWinning));
        }
        return winningInformationDto;
    }

}
