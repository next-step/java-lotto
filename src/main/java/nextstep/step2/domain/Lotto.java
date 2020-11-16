package nextstep.step2.domain;

import java.util.List;

public class Lotto {
	private List<Integer> numbers;
	private LottoReward lottoReward;

	public Lotto(LottoAutoGenerator lottoAutoGenerator) {
		this.numbers = lottoAutoGenerator.getAutoNumbers();
	}

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setLottoReward(List<Integer> winnerNumbers) {
		long matchCount = getNumbers().stream()
				.filter(number -> winnerNumbers.contains(number))
				.count();
		lottoReward = LottoReward.getReword(Math.toIntExact(matchCount));
	}

	public LottoReward getLottoReward() {
		return lottoReward;
	}
}
