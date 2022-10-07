package step02.controller;

import java.util.List;

import step02.domain.EarningRate;
import step02.domain.Lotto;
import step02.domain.LottoList;
import step02.domain.LottoNumber;
import step02.domain.LottoResult;
import step02.domain.LottoSeller;
import step02.domain.WinningLottoNumbers;
import step02.dto.LottoListDto;
import step02.dto.LottoResultDto;
import step02.view.InputView;
import step02.view.PrintView;

public class LottoMain {

    private LottoMain() {
    }

    public static void main(String[] args) {
        int purchasePrice = InputView.initPurchasePrice();
        LottoList lottoList = LottoSeller.sell(purchasePrice);
        PrintView.printLottoPurchaseCountMessage(lottoList.size());
        PrintView.printLottoNumbers(LottoListDto.from(lottoList));

        List<Integer> lastWeekWinningNumbers = InputView.initLastWeekWinningNumbers();
        int bonusBallNumber = InputView.initBonusBallNumber();
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(Lotto.of(lastWeekWinningNumbers), new LottoNumber(bonusBallNumber));

        LottoResult lottoResult = lottoList.generateLottoResult(winningLottoNumbers);
        EarningRate earningRate = new EarningRate(lottoResult.getTotalAmount(), purchasePrice);
        PrintView.printLottoResult(LottoResultDto.of(lottoResult, earningRate));
    }
}
