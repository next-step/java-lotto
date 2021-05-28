package lotto;

import static java.util.Collections.*;

import java.util.List;

public class Lottos {

	private final List<Lotto> values;

	public Lottos(List<Lotto> values) {
		validateLottoList(values);

		this.values = values;
	}

	private static void validateLottoList(List<Lotto> values) {
		if (values.isEmpty()) {
			throw new EmptyLottoListException("로또는 최소 1개 이상 존재해야 합니다.");
		}
	}

	public List<Lotto> values() {
		return unmodifiableList(values);
	}

	public int count() {
		return values.size();
	}
}
