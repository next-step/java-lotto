package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.collections.LottoTicket;
import lotto.collections.LottoTickets;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
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

	public static LottoTicket drawUserPickedTicket(List<Integer> pickedValues) {
		return new ManualLottoNumberGenerator().pickList(pickedValues);
	}

	public static LottoTickets purchaseAutoDrawnTickets(Money money, LottoTickets lottoTickets) {
		final int numberOfPurchasedLotto = money.getNumberOfPurchasedLotto();
		List<LottoTicket> lottoTicketList = new ArrayList<>(lottoTickets.getLottoTickets());
		final int userManuallyDrawnCount = lottoTicketList.size();
		final int autoDrawnCount = numberOfPurchasedLotto - userManuallyDrawnCount;

		for (int index = 0; index < autoDrawnCount; index++) {
			List<LottoNumber> lottoNumberList = new AutoLottoNumberGenerator().pickList();
			lottoTicketList.add(new LottoTicket(lottoNumberList));
		}
		return new LottoTickets(lottoTicketList);
	}
}
