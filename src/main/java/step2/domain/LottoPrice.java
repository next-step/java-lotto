package step2.domain;

public class LottoPrice {

	private final int UNIT_PRICE = 1000;
	private final int purchasePrice;

	public LottoPrice(final int purchasePrice) {
		validate(purchasePrice);
		this.purchasePrice = purchasePrice;
	}

	private void validate(final int purchasePrice) {
		if (purchasePrice < UNIT_PRICE) {
			throw new IllegalArgumentException();
		}
	}
}
