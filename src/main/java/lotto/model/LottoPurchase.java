package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.service.GenerateLotto;
import lotto.utils.TicketCalculator;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;

	public static List<Lotto> buyLotteries(int buyMoney) {
		int ticketNumber = TicketCalculator.calculatorTicketCount(buyMoney);
		List<Lotto> lottoCreateGame = new ArrayList<>();
		for (int i = START_INCLUSIVE; i < ticketNumber; i++) {
			List<Integer> lottoNumbers = GenerateLotto.GenerateLottoNumbers();
			lottoCreateGame.add(new Lotto(lottoNumbers));
		}
		return lottoCreateGame;
	}



}
