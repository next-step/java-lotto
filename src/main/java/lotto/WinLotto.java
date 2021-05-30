package lotto;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class WinLotto {
	public static final int NUMBERS_SIZE = 6;

	private final Set<LottoNo> lottoNumbers = new TreeSet<>();

	public WinLotto(List<Integer> numbers) {
		for (Integer number : numbers) {
			LottoNo lottoNo = new LottoNo(number);
			lottoNumbers.add(lottoNo);
		}
		validateNumbers();
	}

	private void validateNumbers() {
		if (lottoNumbers.size() != NUMBERS_SIZE) {
			throw new IllegalArgumentException("잘못된 번호 모음입니다.");
		}
	}

	public boolean contain(LottoNo lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}
}
