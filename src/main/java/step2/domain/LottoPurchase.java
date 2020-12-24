package step2.domain;

import java.util.Collections;
import java.util.List;

public class LottoPurchase {

	private final LottoPrice lottoPrice;
	private final List<LottoNumbers> manualLottoNumbers;

	public LottoPurchase(final LottoPrice lottoPrice, final List<LottoNumbers> manualLottoNumbers) {
		this.lottoPrice = lottoPrice;
		this.manualLottoNumbers = manualLottoNumbers;
	}

	public LottoPurchase(final LottoPrice lottoPrice) {
		this(lottoPrice, Collections.emptyList());
	}

	public int getAutoLottoIssueCount() {
		return lottoPrice.getNumberOfPurchasesPerUnitPrice() - manualLottoNumbers.size();
	}

	public List<LottoNumbers> getManualLottoNumbers() {
		return manualLottoNumbers;
	}

	public int getManualLottoCount() {
		return this.manualLottoNumbers.size();
	}
}
