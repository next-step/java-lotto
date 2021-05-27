package lotto.model;

public class LottoCount {
	private final int manualCount;
	private final int autoCount;

	private LottoCount(int manualCount, int autoCount) {
		this.manualCount = manualCount;
		this.autoCount = autoCount;
	}

	public static LottoCount of(Money money, int manualCount) {
		validateNonNegative(manualCount, "수동 구매 로또 수는 0 이상이어야 합니다.");
		int totalCount = money.countLotto();
		int autoCount = totalCount - manualCount;
		validateNonNegative(autoCount, "돈이 모자랍니다.");
		return new LottoCount(manualCount, autoCount);
	}

	private static void validateNonNegative(int count, String exceptionMessage) {
		if (count < 0) {
			throw new IllegalArgumentException(exceptionMessage);
		}
	}

	public int getAutoCount() {
		return autoCount;
	}

	public int getManualCount() {
		return manualCount;
	}
}
