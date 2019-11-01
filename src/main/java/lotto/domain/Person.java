package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoCreator.canAffordToBuyLotto;

public class Person {

	private Wallet wallet;
	private List<Lotto> lotteries;

	private Person(long amount, List<Lotto> lotteries) {
		this.wallet = Wallet.of(amount);
		this.lotteries = lotteries;
	}

	public static Person of(long amount) {
		return of(amount, new ArrayList<>());
	}

	public static Person of(long amount, List<Lotto> lotteries) {
		return new Person(amount, lotteries);
	}

	public void buyLottoWithAllMoney() {
		while (canAffordToBuyLotto(wallet)) {
			buyLotto();
		}
	}

	private void buyLotto() {
		lotteries.add(LottoCreator.pickLotto(wallet));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(wallet, person.wallet) &&
				Objects.equals(lotteries, person.lotteries);
	}

	@Override
	public int hashCode() {
		return Objects.hash(wallet, lotteries);
	}

}
