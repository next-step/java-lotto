package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PurchaseTicket {
	private final LottoPrice lottoPrice;
	private final List<LottoNumbers> purchaseLottoNumbers;

	public PurchaseTicket(LottoPrice lottoPrice) {
		this.lottoPrice = lottoPrice;
		this.purchaseLottoNumbers = new ArrayList<>();
	}

	private void auto() {
		IntStream.range(0, lottoPrice.getAutoCount()).forEach(amount ->
			this.purchaseLottoNumbers.add(LottoNumberGenerator.auto()));
	}

	public void manual(String input) {
		if (this.lottoPrice.availablePurchaseManualAmount(this.getPurchaseLottoSize())) {
			throw new IllegalArgumentException("구매 가격을 초과하였습니다.");
		}
		this.purchaseLottoNumbers.add(LottoNumberGenerator.ofInput(input));
	}

	public List<LottoNumbers> getPurchaseLottoNumbers() {
		if (this.lottoPrice.availablePurchaseAutoAmount(this.getPurchaseLottoSize())) {
			auto();
		}
		return Collections.unmodifiableList(this.purchaseLottoNumbers);
	}

	public int getPurchaseLottoSize() {
		return this.purchaseLottoNumbers.size();
	}
}
