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
	private static final int LOTTO_REQUIRED_COUNT = 6;
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

	public static List<LottoNumber> generateManualLotto(List<String> inputStr) throws IllegalArgumentException {

		validationLottoNumberList(inputStr);

		return inputStr.stream()
			.map(s -> new LottoNumber(Integer.parseInt(s)))
			.collect(Collectors.toList());
	}

	private static void validationLottoNumberList(List<String> inputStr) {

		if (inputStr.size() != LOTTO_REQUIRED_COUNT) {
			throw new IllegalArgumentException();
		}

		if (new HashSet<>(inputStr).size() != LOTTO_REQUIRED_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	private static List<LottoNumber> generateRandomLotto() {

		List<Integer> resultLotto = new ArrayList<>(getRandomSet());
		Collections.sort(resultLotto);

		return resultLotto.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	private static Set<Integer> getRandomSet() {
		Set<Integer> tempLotto = new HashSet<>();

		while (tempLotto.size() != LOTTO_REQUIRED_COUNT) {

			tempLotto.add(generateRandomLottoNumber());
		}

		return tempLotto;
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
