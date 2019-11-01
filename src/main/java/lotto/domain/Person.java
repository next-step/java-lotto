package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

	private long amount;
	private List<Lotto> lotteries;

	private Person(long amount, List<Lotto> lotteries) {
		this.amount = amount;
		this.lotteries = lotteries;
	}

	public static Person of(long amount) {
		return of(amount, new ArrayList<>());
	}

	public static Person of(long amount, List<Lotto> lotteries) {
		return new Person(amount, lotteries);
	}

	public void buyLotto() {
		amount -= 1000;
		lotteries.add(LottoCreator.create());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return amount == person.amount &&
				Objects.equals(lotteries, person.lotteries);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, lotteries);
	}

}
