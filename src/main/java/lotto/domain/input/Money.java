package lotto.domain.input;

public class Money {

	private int money;

//	public Money() {
//		this.money = 0;
//	}

	public Money(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void add(Money prizeMoney) {
		this.money += prizeMoney.money;
	}
}
