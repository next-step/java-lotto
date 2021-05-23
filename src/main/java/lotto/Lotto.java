package lotto;

import static java.util.Collections.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class Lotto {
	public static final int NUMBERS_SIZE = 6;

	private final List<LottoNo> lottoNumbers = new ArrayList<>();

	public Lotto(List<Integer> numbers) {
		validateNumbers(numbers);
		for (Integer number : numbers) {
			LottoNo lottoNo = new LottoNo(number);
			lottoNumbers.add(lottoNo);
		}
		sort(lottoNumbers);
	}

	public Lotto(Set<LottoNo> numbers) {
		lottoNumbers.addAll(numbers);
		sort(lottoNumbers);
	}

	public static Lotto publish() {
		Set<LottoNo> numbers = new HashSet<>();
		while(numbers.size() < NUMBERS_SIZE) {
			numbers.add(LottoNo.randomNo());
		}
		return new Lotto(numbers);
	}

	private void validateNumbers(List<Integer> numbers) {
		if (Objects.isNull(numbers) || numbers.size() != NUMBERS_SIZE) {
			throw new IllegalArgumentException("잘못된 번호 모음입니다.");
		}
		duplicatedNumbers(numbers);
	}

	private void duplicatedNumbers(List<Integer> numbers) {
		Set<Integer> numberSet = new HashSet<>(numbers);
		if (numbers.size() != numberSet.size()) {
			throw new IllegalArgumentException("중복된 번호가 존재합니다.");
		}
	}

	public List<Integer> numbers() {
		List<Integer> numbers = new ArrayList<>();
		for (LottoNo lottoNo : lottoNumbers) {
			numbers.add(lottoNo.number());
		}
		return numbers;
	}

	private boolean contain(LottoNo lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	public Prize match(Lotto win) {
		int count = 0;
		for (LottoNo lottoNumber : lottoNumbers) {
			count = win.contain(lottoNumber) ? count + 1 : count;
		}
		return Prize.findByCount(count);
	}


}
