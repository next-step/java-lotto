package lotto.domain;

import lotto.dto.PurchaseInfo;

public class LottoMachine {

	public static final int LOTTO_PRICE = 1000;

	private LottoGenerator lottoGenerator;

	public LottoMachine(LottoGenerator lottoGenerator) {
		this.lottoGenerator = lottoGenerator;
	}

	public LottoTicket purchase(PurchaseInfo purchaseInfo) {
		return new LottoTicket(lottoGenerator.generate(purchaseInfo));
	}
}
