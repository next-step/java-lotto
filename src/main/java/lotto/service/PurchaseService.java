package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.collections.LottoTickets;
import lotto.collections.Money;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.util.AutoLottoNumberGenerator;
import lotto.util.ManualLottoNumberGenerator;

public class PurchaseService {

	public static LottoTickets purchaseAllAuto(final Money money) {
		final int numberOfPurchasedLotto = money.getNumberOfPurchasedLotto();

		List<LottoTicket> lottoTicketList = new ArrayList<>();

		for (int index = 0; index < numberOfPurchasedLotto; index++) {
			List<LottoNumber> lottoNumberList = new AutoLottoNumberGenerator().pickList();
			lottoTicketList.add(new LottoTicket(lottoNumberList));
		}

		return new LottoTickets(lottoTicketList);
	}

	protected static LottoTicket drawUserPickedTicket(List<Integer> pickedValues) {
		List<LottoNumber> lottoNumberList = new ManualLottoNumberGenerator().pickList(pickedValues);
		return new LottoTicket(lottoNumberList);
	}

	public static LottoTickets purchaseAutoDrawnTickets(int autoDrawnCount, LottoTickets lottoTickets) {
		List<LottoTicket> lottoTicketList = new ArrayList<>(lottoTickets.getLottoTickets());

		for (int index = 0; index < autoDrawnCount; index++) {
			List<LottoNumber> lottoNumberList = new AutoLottoNumberGenerator().pickList();
			lottoTicketList.add(new LottoTicket(lottoNumberList));
		}
		return new LottoTickets(lottoTicketList);
	}
}
