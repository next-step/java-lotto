package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.TicketCalculation;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;

	public List<LottoGame> lottoTicketPurchase(int buyMoney) {
		int ticketNumber = TicketCalculation.getLottoTicketNumber(buyMoney);
		List<LottoGame> lottoCreateGame = new ArrayList<>();
		for (int i = START_INCLUSIVE; i < ticketNumber; i++) {
			lottoCreateGame.add(new LottoGame(LottoMachine.createLottoNumber()));
		}
		return lottoCreateGame;
	}

}
