package lotto.modal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
	private static final Random randomGenerator = new Random();
	private final List<LottoNumber> lotto;

	public Lotto() {

		this(generateRandomLotto());
	}

	public Lotto(List<LottoNumber> manualLotto) {

		this.lotto = manualLotto;
	}

	public List<LottoNumber> getLotto() {

		return this.lotto;
	}

	private static List<LottoNumber> generateRandomLotto() {

		Set<Integer> tempLotto = new HashSet<>();

		while (tempLotto.size() != 6) {

			tempLotto.add(generateRandomLottoNumber());
		}

		List<Integer> resultLotto = new ArrayList<>(tempLotto);
		Collections.sort(resultLotto);

		return resultLotto.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	private static int generateRandomLottoNumber() {

		return randomGenerator.nextInt(LottoNumber.LOTTO_NUMBER_BOUND_MAX) + LottoNumber.LOTTO_NUMBER_BOUND_MIN;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto1 = (Lotto)o;
		return Objects.equals(lotto, lotto1.lotto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotto);
	}
}
