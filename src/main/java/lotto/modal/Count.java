package lotto.modal;

public class Count {

	private final int manualBuyCount;
	private final int buyCount;

	private Count(int count, int buyCount) {
		this.buyCount = buyCount;
		this.manualBuyCount = count;
	}

	public static Count generateCount(int count, int buyCount) {
		validateCount(count, buyCount);
		return new Count(count, buyCount);
	}

	private static void validateCount(int count, int buyCount) {
		if (count > buyCount) {
			throw new IllegalArgumentException("금액이 부족합니다.");
		}
	}

	public int manualCount() {
		return this.manualBuyCount;
	}

	public int randomCount() {
		return this.buyCount - this.manualBuyCount;
	}
}

