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

	private static void validateMoney(Money money) {
		if (!money.isEnough()) {
			throw new NotEnoughMoneyException("로또를 구입하기엔 돈이 부족합니다.");
		}
	}

	public List<Lotto> values() {
		return unmodifiableList(values);
	}

	public int count() {
		return values.size();
	}
}
