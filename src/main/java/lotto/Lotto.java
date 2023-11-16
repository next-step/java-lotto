package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Lotto {
	private final static int NUMBER_COUNT = 6;
	private final static int MIN_MATCH = 3;
	private final static int MIN_NUMBER = 1;
	private final static int MAX_NUMBER = 10;
	private final List<Integer> lottoNumbers;

	public Lotto() {
		this.lottoNumbers = randomLottoNumbers();
	}

	public Lotto(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	private List<Integer> randomLottoNumbers() {
		List<Integer> allNumbers = allNumbers();
		List<Integer> randomLottoNumbers = sortedRandomNumbers(allNumbers);

		return Collections.unmodifiableList(randomLottoNumbers);
	}

	private List<Integer> sortedRandomNumbers(List<Integer> numbers) {
		Collections.shuffle(numbers);
		List<Integer> randomLottoNumbers = new ArrayList<>();
		for(int i = 0; i < Lotto.NUMBER_COUNT; i++) {
			randomLottoNumbers.add(numbers.get(i));
		}
		Collections.sort(randomLottoNumbers);

		return randomLottoNumbers;
	}

	private List<Integer> allNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			numbers.add(i);
		}

		return numbers;
	}

	public List<Integer> lottoNumbers() {
		return this.lottoNumbers;
	}

	public void matches(LottoWinningNumbers lottoWinningNumbers,
						Map<LottoMatch, Integer> lottoMatchResult)
	{
		int matchedCount = lottoWinningNumbers.matchedCount(this);
		if(matchedCount < MIN_MATCH) {
			return;
		}

		lottoMatchResult.merge(LottoMatch.fromInt(matchedCount), 1, Integer::sum);
	}
}
