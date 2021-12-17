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

    public Lottos buyAndPrintLotto() {
        String purchaseAmount = InputView.purchaseAmount();
        Lottos lottos = LottosFactory.buyWithMoney(purchaseAmount);
        OutputView.printNumberOfPurchase(lottos.size());
        printLottoNumbersList(lottos);
        return lottos;
    }

    private void printLottoNumbersList(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        for (Lotto lotto : lottoList) {
            OutputView.printLottoNumbers(lotto.getLottoNumbers());
        }
    }

    public void winningInformationOf(Lottos lottos) {
        String winningLotteryNumbers = InputView.winningLotteryNumbers();
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(winningLotteryNumbers);
        Map<Integer, Integer> countNumberOfMatching = lottos.countNumberOfMatching(lottoWinningNumbers);
        LottoWinningRules lottoWinningRules = lottos.getLottoWinningRules();
        List<WinningInformationDto> winningInformationDtoList = winningInformationList(countNumberOfMatching, lottoWinningRules);
        OutputView.printWinningStatics(winningInformationDtoList);
        double earningRate = lottos.earningRate(countNumberOfMatching);
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
