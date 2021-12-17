package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoStore;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    public List<LottoNumbers> buyLotto(){
        int purchaseAmount = InputView.inputPurchaseAmount();
        LottoStore lottoStore = new LottoStore(purchaseAmount);
        return lottoStore.buyingLotto();
    }

    public LottoNumbers inputWinnings(){
        List<Integer> winningsNumberLastWeek = InputView.winningsNumberLastWeek();
        return LottoNumbers.createManualLottoNumber(winningsNumberLastWeek);
    }

//    public LottoCalculate calculatedResult(WinningNumbers winningNumbers, List<LottoNumbers> phrchasedLottos){
//        List<LotteryWinnings> lotteryWinnings = getLotteryWinnings(winningNumbers, phrchasedLottos);
//        int amount = lotteryWinnings.size() * 1000;
//        LottoCalculate lottoResult = new LottoCalculate();
//        return lottoResult.calculatedLotto(lotteryWinnings, amount);
//    }
//
//    private List<LotteryWinnings> getLotteryWinnings(WinningNumbers winningNumbers, List<LottoNumbers> phrchasedLottos) {
//        WinningResult result = new WinningResult(winningNumbers, phrchasedLottos);
//        return result.calculatedLotteryWinnings();
//    }
}
