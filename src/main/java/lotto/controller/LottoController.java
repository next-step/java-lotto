package lotto.controller;

import java.util.List;

import lotto.domain.LotteryDrawing;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStore;
import lotto.dto.PrizeStack;
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

	public PrizeStack calculatedResult(LottoNumbers winningNumbers, List<LottoNumbers> lottoTickets) {
		PrizeStack prizeStack = new PrizeStack();
		for (LottoNumbers lottoTicket : lottoTickets) {
			LotteryDrawing draw = new LotteryDrawing(winningNumbers, lottoTicket);
			prizeStack.add(draw.matchingPrize());
		}
		return prizeStack;
	}

}
