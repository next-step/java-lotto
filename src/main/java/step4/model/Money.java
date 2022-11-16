package step4.model;

public class Money {
	private static final int LOTTO_PRICE = 1000;
	private final int money;

	public Money(final int money) {
		checkValidation(money);
		this.money = money;
	}

	private void checkValidation(final int money){
		if(money <= 1000) {
			throw new IllegalArgumentException("구입 금액은 적어도 1000원 보다 커야합니다. (로또 기본 구매금액 1000원)");
		}
	}

	public int getLottoTicketCnt() {
		return this.money / LOTTO_PRICE;
	}

	public int getMoney() {
		return this.money;
	}
}
