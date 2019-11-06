package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

	private static final int LOTTO_BALL_NUMBERS_LIMIT = 6;

	private final LottoNumbers numbers;
	private final LottoType type;

	private Lotto(List<Integer> inputNumbers, LottoType type) {
		this.numbers = new LottoNumbers(inputNumbers);
		this.type = type;
	}

	private void validateNumbersCount(List<Integer> inputNumbers) {
		if (inputNumbers.size() != LOTTO_BALL_NUMBERS_LIMIT) {
			throw new IllegalArgumentException(String.format("로또는 %s개의 숫자로만 비교될 수 있습니다", LOTTO_BALL_NUMBERS_LIMIT));
		}
	}

	public static Lotto of(List<Integer> inputNumbers) {
		return of(inputNumbers, LottoType.AUTO);
	}

	public static Lotto of(List<Integer> inputNumbers, LottoType type) {
		return new Lotto(inputNumbers, type);
	}

	public LottoPrize examine(List<Integer> answerNumbers, int bonusNumber) {
		validateNumbersCount(answerNumbers);
		validateBonusNumber(answerNumbers, bonusNumber);
		return LottoPrize.of(numbers.countMatchedNumbers(answerNumbers), numbers.isBonusNumberMatched(bonusNumber));
	}

	private void validateBonusNumber(List<Integer> answerNumbers, int bonusNumber) {
		if (answerNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(String.format("보너스 숫자(%s)가 로또 당첨 숫자와 중복됩니다!", bonusNumber));
		}
	}

	public Set<LottoNumber> getNumbers() {
		return numbers.get();
	}

	public LottoType getType() {
		return type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lotto lotto = (Lotto) o;
		return Objects.equals(numbers, lotto.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}

}
