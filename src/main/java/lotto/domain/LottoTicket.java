package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import lotto.domain.strategy.GenerateStrategy;

public class LottoTicket {
	private static final Integer NUMBERS_COUNT = 6;
	private final Set<Integer> numbers;
	private Rank rank;

	public LottoTicket(GenerateStrategy strategy) {
		this.numbers = strategy.generate();
		this.rank = Rank.NOT;
		isNumbersSizeEqCount();
	}

	public List<Integer> getNumbersToList() {
		List<Integer> numberList = new ArrayList<>(numbers);
		Collections.sort(numberList);
		return Collections.unmodifiableList(numberList);
	}

	public Rank getRank() {
		return rank;
	}

	private void isNumbersSizeEqCount() {
		if (numbers.size()!= NUMBERS_COUNT) {
			throw new IllegalArgumentException("올바르지 않은 추첨 결과입니다.");
		}
	}

	public void updateRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "LottoTicket{" +
			"numbers=" + numbers +
			", rank=" + rank +
			'}';
	}
}
