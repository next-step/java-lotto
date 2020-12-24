package lotto.modal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.util.StringValid;

public class Lotto {
	private static final String LOTTO_NUMBER_SEPARATOR = ",";
	private static final int LOTTO_REQUIRED_COUNT = 6;

	private final List<LottoNumber> lotto;

	private Lotto(List<LottoNumber> manualLotto) {
		this.lotto = manualLotto;
	}

	public static Lotto generateManualLotto(String userInputLotto) {
		validationWinnerLotto(userInputLotto);
		return new Lotto(generateUserLotto(userInputLotto));
	}

	public static Lotto generateRandomLotto() {
		List<Integer> resultLotto = new ArrayList<>(getRandomSet());
		Collections.sort(resultLotto);

		return new Lotto(resultLotto.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList()));
	}

	public List<LottoNumber> getLotto() {
		return this.lotto;
	}

	private static List<LottoNumber> generateUserLotto(String userInputLotto) {
		String[] lottoArray = userInputLotto.replace(" ", "").split(LOTTO_NUMBER_SEPARATOR);
		return Lotto.generateManualLotto(Arrays.asList(lottoArray));
	}

	private static List<LottoNumber> generateManualLotto(List<String> inputStr) throws IllegalArgumentException {
		validationLottoNumbers(inputStr);

		return inputStr.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	public boolean isContainNumber(LottoNumber bonusNumber) {
		return this.lotto.contains(bonusNumber);
	}

	private static void validationWinnerLotto(String userInputLotto) {
		if (StringValid.isEmptyStr(userInputLotto)) {
			throw new IllegalArgumentException("당첨 로또를 입력해주세요.");
		}
	}

	private static void validationLottoNumbers(List<String> inputStr) {
		if (new HashSet<>(inputStr).size() != LOTTO_REQUIRED_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	private static Set<Integer> getRandomSet() {
		Set<Integer> tempLotto = new HashSet<>();

		while (tempLotto.size() != LOTTO_REQUIRED_COUNT) {
			tempLotto.add(LottoNumber.generateRandomLottoNumber());
		}
		return tempLotto;
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

	@Override
	public String toString() {
		return lotto.toString();
	}
}
