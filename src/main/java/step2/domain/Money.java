package step2.domain;

import java.util.Objects;

import step2.exception.MoneyOverLimitException;
import step2.exception.NotEnoughMoneyException;

public class Money {
	private final int money;

	public Money(String moneyString) {
		try {
			money = Integer.parseInt(moneyString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("입력값이 잘못되었습니다.");
		}
	}

	public Money(int money) {
		this.money = money;
	}

	public int getMoney() {
		return this.money;
	}

	public Money pay(int payMoney) {
		return new Money(this.money - payMoney);
	}

	public void checkMaxMoney(int maxMoney) {
		if (this.money > maxMoney) {
			throw new MoneyOverLimitException();
		}
	}

	public int getPurchasableCount(int price) {
		if (this.money < price) {
			throw new NotEnoughMoneyException();
		}
		return this.money / price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money1 = (Money)o;
		return money == money1.money;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(money);
	}

	public Double getProfitByGainedMoney(int gainedMoney) {
		return (double)(gainedMoney - this.money) / this.money * 100;
	}
}
