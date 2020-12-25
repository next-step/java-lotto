package step2.domain;

public class LottoPrice {

	private final static int DEFAULT_UNIT_PRICE = 1000;
	private final int unitPrice;
	private final int purchasePrice;

	public LottoPrice(final int unitPrice, final int purchasePrice) {
		this.unitPrice = unitPrice;
		validate(purchasePrice);
		this.purchasePrice = purchasePrice;
	}

	public LottoPrice(final int purchasePrice) {
		this(DEFAULT_UNIT_PRICE, purchasePrice);
	}

	private void validate(final int purchasePrice) {
		if (purchasePrice < unitPrice) {
			throw new IllegalArgumentException();
		}
	}

	public int getNumberOfPurchasesPerUnitPrice() {
		return this.purchasePrice / this.unitPrice;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public int getUnitPrice() {
		return unitPrice;
	}
}
