package lotto.controller;

import java.util.List;

import lotto.domain.*;
import lotto.domain.LottoResult;
import lotto.view.InputView;

public class LottoController {

	public LottoStore readyToBuyLotto() {
		int purchaseAmount = InputView.inputPurchaseAmount();
		int manualLottoCount = InputView.inputManualLottoCount();
		return createdLottoStore(purchaseAmount, manualLottoCount);
	}

	public List<LottoNumbers> buyLotto(LottoStore lottoStore) {
		return buyingLotto(lottoStore);
	}

	private List<LottoNumbers> buyingLotto(LottoStore lottoStore) {
		if (lottoStore.containManualLotto()) {
			List<List<Integer>> userInputs = InputView.inputManualLottoNumbers(lottoStore.getManualBuyingCount());
			return lottoStore.buyingAutoAndManualLotto(userInputs);
		}
		return lottoStore.buyingAutoLotto();
	}

	private LottoStore createdLottoStore(int purchaseAmount, int manualLottoCount) {
		if (manualLottoCount > 0) {
			return new LottoStore(purchaseAmount, manualLottoCount);
		}
		return new LottoStore(purchaseAmount);
	}

	public LottoNumbers inputWinnings() {
		List<Integer> winningsNumberLastWeek = InputView.userInputLastWeekLottoNumbers();
		return LottoNumbers.createManualLottoNumber(winningsNumberLastWeek);
	}

	public LottoNumber inputBonusNumber() {
		int bonusNumber = InputView.inputBonusNumber();
		return new LottoNumber(bonusNumber);
	}

	public LottoResult calculatedResult(LottoNumbers winningNumbers, LottoNumber bonusNumber,
		List<LottoNumbers> lottoTickets) {
		LottoResult lottoResult = new LottoResult(lottoTickets.size());

		for (LottoNumbers lottoTicket : lottoTickets) {
			MatchedLotto draw = new MatchedLotto(winningNumbers, bonusNumber, lottoTicket);
			lottoResult.add(draw.matchingPrize());
		}
		return calculatePrizeCount(lottoResult);
	}

	private LottoResult calculatePrizeCount(LottoResult lottoResult) {
		lottoResult.calculatePrizeCount();
		return lottoResult;
	}

}
