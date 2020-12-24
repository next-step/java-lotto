package lotto.modal;

public class Count {

	private final int manualBuyCount;
	private final int buyCount;

	public Count(int count, int buyCount) {
		validateCount(count, buyCount);
		this.buyCount = buyCount;
		this.manualBuyCount = count;
	}

	private void validateCount(int count, int buyCount) {
		if (count > buyCount) {
			throw new IllegalArgumentException("금액이 부족합니다.");
		}
	}
}
