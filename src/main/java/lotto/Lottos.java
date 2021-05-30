package lotto;

import static java.util.Collections.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

	private final List<Lotto> values;

	public Lottos(List<Lotto> values) {
		validateLottoList(values);

		this.values = values;
	}

	public Lottos(Lottos... lottos) {
		this(Arrays.stream(lottos)
			.map(Lottos::values)
			.flatMap(Collection::stream)
			.collect(Collectors.toList()));
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lottos lottos = (Lottos)o;
		return Objects.equals(values, lottos.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}
}
