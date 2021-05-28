package lotto;

import static lotto.LottoPrize.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

	public static final int MAX_LOTTO_COUNT = 6;

	private List<LottoNumber> lottoNumbers;

	public Lotto(List<LottoNumber> numbers) {
		validate(numbers);
		this.lottoNumbers = sortNumber(numbers);
	}

	public LottoPrize compare(WinningLotto winningLotto) {
		long matchCount = lottoNumbers.stream().filter(winningLotto::contains).count();
		boolean isMatchBonus = lottoNumbers.stream().anyMatch(winningLotto::isMatchBonusNumber);
		return getLottoPrizeFromMatchCount(matchCount, isMatchBonus);
	}

	private void validate(List<LottoNumber> numbers) {
		if(numbers.size() != MAX_LOTTO_COUNT) {
			throw new IllegalArgumentException("로또 숫자가 6개가 아닙니다.");
		}

		Set<LottoNumber> set = new HashSet<>(numbers);
		if(set.size() != MAX_LOTTO_COUNT) {
			throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
		}
	}

	private List<LottoNumber> sortNumber(List<LottoNumber> numbers) {
		Collections.sort(numbers);
		return numbers;
	}

	@Override
	public String toString() {
		return "[" + lottoNumbers.stream()
			.map(LottoNumber::toString)
			.collect(Collectors.joining(",")) + "]";
	}
}
