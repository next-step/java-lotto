package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.collections.LottoTickets;
import lotto.collections.Money;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.util.AutoLottoNumberGenerator;

public class PurchaseService {

	public static LottoTickets purchase(final Money money) {
		final int numberOfPurchasedLotto = money.getNumberOfPurchasedLotto();

		List<LottoTicket> lottoTicketList = new ArrayList<>();

		for (int index = 0; index < numberOfPurchasedLotto; index++) {
			List<LottoNumber> lottoNumberList = AutoLottoNumberGenerator.pickList();
			lottoTicketList.add(new LottoTicket(lottoNumberList));
		}

		return new LottoTickets(lottoTicketList);
	}

	public static LottoTickets purchase2(final Money money) {
		final int numberOfPurchasedLotto = money.getNumberOfPurchasedLotto();

		List<LottoTicket> lottoTicketList = new ArrayList<>();

		for (int index = 0; index < numberOfPurchasedLotto; index++) {
			List<LottoNumber> lottoNumberList = AutoLottoNumberGenerator.pickList();
			lottoTicketList.add(new LottoTicket(lottoNumberList));
		}

		return new LottoTickets(lottoTicketList);
	}
}
