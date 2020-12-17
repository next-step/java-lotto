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

	public static Lotto generateWinnerLotto(String userInputLotto) {
		validationWinnerLotto(userInputLotto);
		return new Lotto(getInputLottoList(userInputLotto));
	}

	private static List<LottoNumber> getInputLottoList(String userInputLotto) {
		String[] lottoArray = userInputLotto.replace(" ", "").split(LOTTO_NUMBER_SEPARATOR);
		return Lotto.generateManualLotto(Arrays.asList(lottoArray));
	}

	private static void validationWinnerLotto(String userInputLotto) {
		if (StringValid.isEmptyStr(userInputLotto)) {
			throw new IllegalArgumentException("당첨 로또를 입력해주세요.");
		}
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
			tempLotto.add(LottoNumber.generateRandomLottoNumber());
		}
		return tempLotto;
	}

	public int getMatchCount(Lotto compareLotto) {
		int count = 0;

		if (this.equals(compareLotto)) {
			return LOTTO_REQUIRED_COUNT;
		}

		for (LottoNumber number : this.lotto) {
			count += compareLotto.isContain(number);
		}
		return count;
	}

	private int isContain(LottoNumber number) {
		if (this.lotto.contains(number)) {
			return 1;
		}
		return 0;
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
