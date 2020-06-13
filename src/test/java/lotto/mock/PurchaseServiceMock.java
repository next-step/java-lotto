package lotto.mock;

import java.util.ArrayList;
import java.util.List;

import lotto.collections.LottoTicket;
import lotto.collections.LottoTickets;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
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
			List<LottoNumber> lottoNumberList = new AutoLottoNumberGenerator().pickList();
			lottoTicketList.add(new LottoTicket(lottoNumberList));
		}
		return new LottoTickets(lottoTicketList);
	}
}
