package lotto.view.dto;

public class PurchaseCountDto {

	private final int purChaseCount;

	private PurchaseCountDto(int purChaseCount) {
		this.purChaseCount = purChaseCount;
	}

	public static PurchaseCountDto of(int purChaseCount) {
		return new PurchaseCountDto(purChaseCount);
	}

	public int getPurChaseCount() {
		return purChaseCount;
	}
}
