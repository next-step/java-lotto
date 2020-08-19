package step3.domain;

import step3.LottoException;
import step3.constants.PrizeGrade;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static step3.configuration.LottoConfig.NUMBER_COUNT_PER_GAME;
import static step3.constants.MessageConstant.NUMBER_COUNT_SHOULD_BE_N;

public class LottoGame {

	private final Set<LottoNumber> lottoNumbers;

	private static final int ZERO = 0;
	private static final int MATCH = 1;
	private static final int NON_MATCH = ZERO;

	private static final String OPEN_PARENTHESIS = "[";
	private static final String CLOSE_PARENTHESIS = "]";
	private static final String DELIMITER = ", ";

	public LottoGame(List<LottoNumber> lottoNumberPool) {
		this.lottoNumbers = lottoNumberPool.stream().limit(NUMBER_COUNT_PER_GAME).collect(Collectors.toSet());
	}

	public LottoGame(String[] numbers) {
		this.lottoNumbers = createLottoNumbers(numbers);
	}

	boolean contains(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}


	public PrizeGrade confirmPrize(PrizeInfo prize) {
		return PrizeGrade.of(getMatchCount(prize), isMatchBonusNumber(prize));
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

	private int getMatchCount(PrizeInfo prizeInfo) {
		return this.lottoNumbers
				.stream()
				.map(lottoNumber -> {
					if(prizeInfo.contains(lottoNumber)) {
						return MATCH;
					}
					return NON_MATCH;
				})
				.reduce(ZERO, Integer::sum);

	}

	private boolean isMatchBonusNumber(PrizeInfo prizeInfo) {
		return this.lottoNumbers
				.stream()
				.anyMatch(lottoNumber -> prizeInfo.isMatchBonusNumber(lottoNumber));
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
