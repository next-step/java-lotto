package lotto.controller;

import java.util.List;

import lotto.domain.*;
import lotto.domain.LottoResult;
import lotto.view.InputView;

public class LottoController {

	public List<LottoNumbers> buyLotto() {
		int purchaseAmount = InputView.inputPurchaseAmount();
		LottoStore lottoStore = new LottoStore(purchaseAmount);
		return lottoStore.buyingLotto();
	}

	public LottoNumbers inputWinnings() {
		List<Integer> winningsNumberLastWeek = InputView.winningsNumberLastWeek();
		return LottoNumbers.createManualLottoNumber(winningsNumberLastWeek);
	}

	public LottoNumber inputBonusNumber() {
		int bonusNumber = InputView.inputBonusNumber();
		return new LottoNumber(bonusNumber);
	}

	public LottoResult calculatedResult(LottoNumbers winningNumbers, LottoNumber bonusNumber, List<LottoNumbers> lottoTickets) {
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
