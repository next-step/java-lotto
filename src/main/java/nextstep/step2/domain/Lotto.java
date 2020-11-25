package nextstep.step2.domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
	private static final String WRONG_LOTTO_NUMBERS = "로또 번호는 6개여야 합니다.";
	protected static final int LOTTO_SIZE = 6;
	private Set<LottoNumber> numbers;
	private LottoReward lottoReward;

	public Lotto() {
	}
	public Lotto(Set<LottoNumber> numbers) {
		this.numbers = numbers;
		validate();
	}

	public Set<LottoNumber> getNumbers() {
		return numbers;
	}

	public void validate() {
		if (numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(WRONG_LOTTO_NUMBERS);
		}
	}

	public static Lotto of(String numbers) {
		String[] winningNumberSplit = numbers.replaceAll(" ", "").split(",");
		return Stream.of(winningNumberSplit)
				.map(number -> LottoNumber.of(LottoNumber.getValidateNumber(number)))
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Lotto::new));
	}

	public void setLottoReward(LottoReward lottoReward) {
		this.lottoReward = lottoReward;
	}

	public LottoReward getLottoReward() {
		return lottoReward;
	}
}
