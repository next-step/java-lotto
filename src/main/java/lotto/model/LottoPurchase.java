package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.TicketCalculation;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;

	public List<Lotto> lottoTicketPurchase(int buyMoney) {
		int ticketNumber = TicketCalculation.getLottoTicketNumber(buyMoney);
		List<Lotto> lottoCreateGame = new ArrayList<>();
		for (int i = START_INCLUSIVE; i < ticketNumber; i++) {
			List<Integer> lottoNumbers = createLottoNumber();
			lottoCreateGame.add(new Lotto(lottoNumbers));
		}
		return lottoCreateGame;
	}

	private List<Integer> createLottoNumber() {
		return new ArrayList<>(LottoMachine.createLottoNumber());
	}

}
