package lotto.controller;

import java.util.List;

import lotto.domain.LotteryWinnings;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStore;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.domain.LottoCalculate;
import lotto.view.InputView;

public class LottoController {

	public List<LottoNumbers> buyLotto(){
		int purchaseAmount = InputView.inputPurchaseAmount();
		LottoStore lottoStore = new LottoStore(purchaseAmount);
		return lottoStore.buyLotto();
	}

	public WinningNumbers inputWinnings(){
		List<Integer> winningsNumberLastWeek = InputView.winningsNumberLastWeek();
		return new WinningNumbers(winningsNumberLastWeek);
	}

	public LottoCalculate calculatedResult(WinningNumbers winningNumbers, List<LottoNumbers> phrchasedLottos){
		List<LotteryWinnings> lotteryWinnings = getLotteryWinnings(winningNumbers, phrchasedLottos);
		int amount = lotteryWinnings.size() * 1000;
		LottoCalculate lottoResult = new LottoCalculate();
		return lottoResult.calculatedLotto(lotteryWinnings, amount);
	}

	private List<LotteryWinnings> getLotteryWinnings(WinningNumbers winningNumbers, List<LottoNumbers> phrchasedLottos) {
		WinningResult result = new WinningResult(winningNumbers, phrchasedLottos);
		return result.calculatedLotteryWinnings();
	}

}
