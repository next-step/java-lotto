package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lotto.domain.strategy.GenerateStrategy;

public class LottoTicket {
	private Set<LottoNumber> numbers;

	public LottoTicket(GenerateStrategy strategy) {
		numbers = new LinkedHashSet<>();
		this.numbers = strategy.generate();
		isNumbersSizeEqCount();
	}

	public LottoTicket(int... nums) {
		numbers = new LinkedHashSet<>();
		for (int num : nums) {
			this.numbers.add(new LottoNumber(num));
		}
		isNumbersSizeEqCount();
	}

	public List<LottoNumber> getNumbers() {
		return Collections.unmodifiableList(new ArrayList<>(numbers));
	}

	private void isNumbersSizeEqCount() {
		if (numbers.size() != LottoConfig.NUMBERS_COUNT) {
			throw new IllegalArgumentException("올바르지 않은 추첨 결과입니다.");
		}
	}
}
