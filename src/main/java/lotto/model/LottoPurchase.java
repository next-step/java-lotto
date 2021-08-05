package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.service.GenerateLotto;
import lotto.utils.LottoTicketCalculator;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;

	public static List<Lotto> buyLotteries(int money) {
		int ticketCount = LottoTicketCalculator.calculatorLottoTicketCount(money);
		List<Lotto> lotteries = new ArrayList<>();
		for (int i = START_INCLUSIVE; i < ticketCount; i++) {
			List<Integer> lottoNumbers = GenerateLotto.GenerateLottoNumbers();
			lotteries.add(new Lotto(lottoNumbers));
		}
		return lotteries;
	}

}
