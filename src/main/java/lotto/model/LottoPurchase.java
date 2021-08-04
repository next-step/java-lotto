package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.TicketCalculation;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;

	private final LottoGames lottoGames;

	public LottoPurchase(int buyMoney) {
		List<LottoGame> lottoCreateGame = new ArrayList<>();
		for (int i = START_INCLUSIVE; i < TicketCalculation.getLottoTicketNumber(buyMoney); i++) {
			lottoCreateGame.add(new LottoGame(LottoMachine.createLottoNumber()));
		}
		lottoGames = new LottoGames(lottoCreateGame);
	}

	public List<LottoGame> resultLottoGame() {
		return lottoGames.getLottoGames();
	}

}
