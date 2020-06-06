package lotto.mock;

import java.util.ArrayList;
import java.util.List;

import lotto.collections.LottoTickets;
import lotto.collections.Money;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.service.PurchaseService;
import lotto.util.AutoLottoNumberGenerator;

public class PurchaseServiceMock extends PurchaseService {

	public static int countToAutoDrawnLotto(final Money money, LottoTickets lottoTickets) {
		final int numberOfPurchasedLotto = money.getNumberOfPurchasedLotto();
		return numberOfPurchasedLotto - lottoTickets.getLottoTickets().size();
	}

	public static LottoTickets purchaseAutoDrawnLotto(int autoDrawnCount, LottoTickets lottoTickets) {
		List<LottoTicket> lottoTicketList = new ArrayList<>(lottoTickets.getLottoTickets());

		for (int index = 0; index < autoDrawnCount; index++) {
			List<LottoNumber> lottoNumberList = AutoLottoNumberGenerator.pickList();
			lottoTicketList.add(new LottoTicket(lottoNumberList));
		}
		return new LottoTickets(lottoTicketList);
	}
}
