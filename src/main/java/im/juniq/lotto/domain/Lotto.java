package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	private static final int FIRST_LOTTO_NUMBER = 1;
	private static final int LAST_LOTTO_NUMBER = 45;
	private static final int NUMBER_OF_PICKUP = 6;
	private LottoNumbers lottoNumbers;

	public Lotto() {
		List<Integer> baseNumbers = makeBaseNumbers();
		new NormalShuffleStrategy().shuffle(baseNumbers);
		lottoNumbers = new LottoNumbers(pickupNumbers(baseNumbers));
	}

	public Lotto(ShuffleStrategy shuffleStrategy) {
		List<Integer> baseNumbers = makeBaseNumbers();
		shuffleStrategy.shuffle(baseNumbers);
		lottoNumbers = new LottoNumbers(pickupNumbers(baseNumbers));
	}

	public Lotto(String lotto) {
		lottoNumbers = new LottoNumbers(Arrays.stream(lotto.split(",")).map(Integer::valueOf).collect(Collectors.toList()));
	}

	public LottoNumbers numbers() {
		return lottoNumbers;
	}

	private List<Integer> makeBaseNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = FIRST_LOTTO_NUMBER; i <= LAST_LOTTO_NUMBER; i++) {
			numbers.add(i);
		}
		return numbers;
	}

	private List<Integer> pickupNumbers(List<Integer> baseNumbers) {
		List<Integer> results = baseNumbers.subList(0, NUMBER_OF_PICKUP);
		Collections.sort(results);
		return results;
	}

	public Winning winning(WinningNumbers winningNumbers) {
		return Winning
				.findByMatchedCount(numberOfMatchedWinningNumber(winningNumbers), matchedBonusNumber(winningNumbers));
	}

	private int numberOfMatchedWinningNumber(WinningNumbers winningNumbers) {
		return winningNumbers.matchedCount(lottoNumbers);
	}

	private boolean matchedBonusNumber(WinningNumbers winningNumbers) {
		return winningNumbers.matchedBonusNumber(lottoNumbers);
	}

	public long prize(WinningNumbers winningNumbers) {
		return winning(winningNumbers).amount();
	}
}
