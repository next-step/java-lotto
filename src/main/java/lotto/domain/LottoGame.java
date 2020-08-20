package lotto.domain;

import lotto.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.configuration.LottoConfig.NUMBER_COUNT_PER_GAME;
import static lotto.constants.MessageConstant.NUMBER_COUNT_SHOULD_BE_N;

public class LottoGame {

	private static final String OPEN_PARENTHESIS = "[";
	private static final String CLOSE_PARENTHESIS = "]";
	private static final String DELIMITER = ", ";

	private final Set<LottoNumber> lottoNumbers;

	public LottoGame(List<LottoNumber> lottoNumberPool) {
		this.lottoNumbers = lottoNumberPool.stream().limit(NUMBER_COUNT_PER_GAME).collect(Collectors.toSet());
	}

	public LottoGame(String[] numbers) {
		this.lottoNumbers = createLottoNumbers(numbers);
	}

	public boolean contains(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	public Set<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	private Set<LottoNumber> createLottoNumbers(String[] numbers) {

		Set<LottoNumber> lottoNumbers = Arrays.stream(numbers)
											.map(LottoNumber::new)
											.collect(Collectors.toSet());

		if (!isValidNumberCount(lottoNumbers)) {
			throw new LottoException(String.format(NUMBER_COUNT_SHOULD_BE_N, NUMBER_COUNT_PER_GAME));
		}
		return lottoNumbers;
	}

	private boolean isValidNumberCount(Set<LottoNumber> lottoNumbers) {
		return lottoNumbers.size() == NUMBER_COUNT_PER_GAME;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		String collect = lottoNumbers.stream()
									.sorted()
									.map(LottoNumber::toString)
									.collect(Collectors.joining(DELIMITER));

		stringBuilder.append(OPEN_PARENTHESIS)
					.append(collect)
					.append(CLOSE_PARENTHESIS);

		return stringBuilder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoGame lottoGame = (LottoGame) o;
		return lottoNumbers.equals(lottoGame.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
