package lotto.domain;

import lotto.dto.PurchaseInfo;

public class LottoMachine {

	private LottoGenerator lottoGenerator;

	public LottoMachine(LottoGenerator lottoGenerator) {
		this.lottoGenerator = lottoGenerator;
	}

	public LottoTicket purchase(PurchaseInfo purchaseInfo) {
		return new LottoTicket(lottoGenerator.generate(purchaseInfo));
	}
}
