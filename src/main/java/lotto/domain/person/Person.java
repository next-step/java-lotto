package lotto.domain.person;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	public void buyLottoWithAllMoney(LottoCreator lottoCreator) {
		while (lottoCreator.canAffordToBuyLotto(wallet)) {
			buyLotto(lottoCreator);
		}
	}

	private void buyLotto(LottoCreator lottoCreator) {
		lotteries.add(lottoCreator.pickLotto(wallet));
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
