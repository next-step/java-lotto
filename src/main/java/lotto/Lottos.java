package lotto;

import static java.util.Collections.*;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	private final List<Lotto> values;

	public Lottos(Money money) {
		validateMoney(money);

		values = new ArrayList<>();
		for (int i = 0; i < money.buyCount(); i++) {
			values.add(new Lotto());
		}
	}

	public Lottos(List<Lotto> values) {
		this.values = values;
	}

	public List<Lotto> values() {
		return unmodifiableList(values);
	}

	public int count() {
		return values.size();
	}

	private static void validateMoney(Money money) {
		if (!money.isEnough()) {
			throw new IllegalArgumentException("Not enough money to buy a lotto.");
		}
	}
}
