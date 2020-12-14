package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
	private final List<LottoNumbers> lottoNumbers;

	public LottoTicket(List<LottoNumbers> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public static LottoTicket ofPurchase(PurchaseTicket purchaseTicket) {
		return new LottoTicket(purchaseTicket.getPurchaseLottoNumbers());
	}

	public List<LottoNumbers> getLottoNumbers() {
		return this.lottoNumbers;
	}
}
