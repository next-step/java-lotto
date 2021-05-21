package lotto;

import static java.util.Collections.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Lotto {
	public static final int NUMBERS_SIZE = 6;
	private final List<LottoNo> lottoNumbers = new ArrayList<>();

	public Lotto(List<Integer> numbers) {
		validateNumbers(numbers);
		for (Integer number : numbers) {
			LottoNo lottoNo = new LottoNo(number);
			duplicatedNumber(lottoNo);
			lottoNumbers.add(lottoNo);
		}
		sort(lottoNumbers);
	}

	private void validateNumbers(List<Integer> numbers) {
		if (Objects.isNull(numbers) || numbers.size() != NUMBERS_SIZE) {
			throw new IllegalArgumentException("잘못된 번호 모음입니다.");
		}
	}

	private void duplicatedNumber(LottoNo lottoNo) {
		if (lottoNumbers.contains(lottoNo)) {
			throw new IllegalArgumentException(String.format("중복된 로또 번호가 존재합니다 : %d", lottoNo.number()));
		}
	}

	public List<Integer> numbers() {
		List<Integer> numbers = new ArrayList<>();
		for (LottoNo lottoNo : lottoNumbers) {
			numbers.add(lottoNo.number());
		}
		return numbers;
	}
}
