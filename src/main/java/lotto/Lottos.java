package lotto;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

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

	public Lottos mergeWith(Lottos lottos) {
		return new Lottos(Stream.of(values, lottos.values)
			.flatMap(Collection::stream)
			.collect(toList()));
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
