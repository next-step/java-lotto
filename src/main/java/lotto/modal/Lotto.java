package lotto.modal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
	private static final String LOTTO_NUMBER_SEPARATOR = ",";
	private static final int LOTTO_REQUIRED_COUNT = 6;

	private final List<LottoNumber> lotto;

	private Lotto(List<LottoNumber> manualLotto) {
		this.lotto = manualLotto;
	}

	public static Lotto generateManualLotto(String userInputLotto) {
		return new Lotto(generateUserLotto(userInputLotto));
	}

	public static Lotto generateRandomLotto() {
		return new Lotto(LottoNumber.generateRandomNumbers());
	}

	public int compareLottoCount(Lotto targetLotto) {
		return targetLotto.getLotto().stream()
			.mapToInt(this::isContain)
			.sum();
	}

	public int isContain(LottoNumber number) {
		if (isContainNumber(number)) {
			return 1;
		}
		return 0;
	}

	public boolean isContainNumber(LottoNumber bonusNumber) {
		return this.lotto.contains(bonusNumber);
	}

	private static List<LottoNumber> generateUserLotto(String userInputLotto) {
		String[] lottoArray = userInputLotto.replace(" ", "").split(LOTTO_NUMBER_SEPARATOR);
		validateLottoNumbers(lottoArray);

		return Arrays.stream(lottoArray)
			.map(LottoNumber::generateNumber)
			.collect(Collectors.toList());
	}

	private static void validateLottoNumbers(String[] lottoNumber) {
		if (lottoNumber.length != LOTTO_REQUIRED_COUNT) {
			throw new IllegalArgumentException("로또 번호가 6개가 아닙니다.");
		}
	}

	public List<LottoNumber> getLotto() {
		return this.lotto;
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
