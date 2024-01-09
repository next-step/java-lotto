package lotto.domain;

public final class Money {
	private static final int WON1000 = 1000;

	private final Integer price;

	public Money(Integer price) {
		validate(price);
		this.price = price;
	}

	private void validate(Integer price) {
		if (price < 1000) {
			throw new IllegalArgumentException("투입 금액이 1000원 미만입니다.");
		}
	}

	public int numberOfLotto(final int manualCount) {
		int number = this.price / WON1000;
		System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", manualCount, number - manualCount);

		return number;
	}

	public double calculateRate(final LottoResult lottoResult) {
		return lottoResult.totalPrize() / (double)this.price;
	}
}
