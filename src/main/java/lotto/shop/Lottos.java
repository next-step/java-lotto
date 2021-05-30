package lotto.shop;

import static java.util.Collections.*;
import static lotto.shop.LottoShop.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.EmptyLottoListException;
import lotto.Lotto;

public class Lottos {

	private final boolean certified;

	private final List<Lotto> values;

	Lottos(boolean certified, List<Lotto> values) {
		validateLottoList(values);

		this.certified = certified;
		this.values = values;
	}

	Lottos(boolean certified, Lottos... lottos) {
		this(certified, Arrays.stream(lottos)
			.map(Lottos::values)
			.flatMap(Collection::stream)
			.collect(Collectors.toList()));
	}

	public Lottos(List<Lotto> values) {
		this(false, values);
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

	public int totalPrice() {
		return values.size() * LOTTO_PRICE;
	}

	public boolean validate() {
		return certified;
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
