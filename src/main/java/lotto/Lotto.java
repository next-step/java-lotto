package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class Lotto {
	public static final int NUMBERS_SIZE = 6;

	private final Set<LottoNo> lottoNumbers = new TreeSet<>();

	public Lotto(List<Integer> numbers) {
		for (Integer number : numbers) {
			LottoNo lottoNo = new LottoNo(number);
			lottoNumbers.add(lottoNo);
		}
		validateNumbers();
	}

	public Lotto(Set<LottoNo> numbers) {
		lottoNumbers.addAll(numbers);
	}

	public static Lotto publish() {
		Set<LottoNo> numbers = new HashSet<>();
		while(numbers.size() < NUMBERS_SIZE) {
			numbers.add(LottoNo.randomNo());
		}
		return new Lotto(numbers);
	}

	private void validateNumbers() {
		if (lottoNumbers.size() != NUMBERS_SIZE) {
			throw new IllegalArgumentException("잘못된 번호 모음입니다.");
		}
	}

	public List<Integer> numbers() {
		List<Integer> numbers = new ArrayList<>();
		for (LottoNo lottoNo : lottoNumbers) {
			numbers.add(lottoNo.number());
		}
		return numbers;
	}

	public Prize result(WinLotto winLotto) {
		int count = 0;
		for (LottoNo lottoNumber : lottoNumbers) {
			count = winLotto.contain(lottoNumber) ? count + 1 : count;
		}
		return Prize.findByCount(count);
	}
}
