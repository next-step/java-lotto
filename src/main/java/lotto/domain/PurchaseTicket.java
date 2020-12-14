package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PurchaseTicket {
	private LottoPrice lottoPrice;
	private final List<LottoNumbers> purchaseLottoNumbers;

	public PurchaseTicket(LottoPrice lottoPrice) {
		this.lottoPrice = lottoPrice;
		this.purchaseLottoNumbers = new ArrayList<>();
		auto();
	}

	public PurchaseTicket(List<LottoNumbers> purchaseLottoNumbers) {
		this.purchaseLottoNumbers = purchaseLottoNumbers;
	}

	private void auto() {
		IntStream.range(0, lottoPrice.availablePurchaseAutoAmount()).forEach(amount ->
			this.purchaseLottoNumbers.add(LottoNumberGenerator.auto()));
	}

	public void manual(LottoNumbers manualLottoNumbers) {
		if (!this.lottoPrice.availablePurchaseManualAmount()) {
			throw new IllegalArgumentException("구매 가격을 초과하였습니다.");
		}
		this.purchaseLottoNumbers.add(manualLottoNumbers);
	}

	public List<LottoNumbers> getPurchaseLottoNumbers() {
		return Collections.unmodifiableList(this.purchaseLottoNumbers);
	}

	public int getPurchaseLottoSize() {
		return this.purchaseLottoNumbers.size();
	}
}
