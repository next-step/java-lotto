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
			List<Integer> lottoNumbers = createLottoNumber();
			lottoCreateGame.add(new LottoGame(lottoNumbers));
		}
		return lottoCreateGame;
	}

	private List<Integer> createLottoNumber() {
		return new ArrayList<>(LottoMachine.createLottoNumber());
	}

}
