package lotto;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class WinLotto {
	public static final int NUMBERS_SIZE = 6;

	private final Set<LottoNo> lottoNumbers = new TreeSet<>();
	private final LottoNo bonusNo;

	public WinLotto(List<Integer> numbers, Integer bonusNumber) {
		for (Integer number : numbers) {
			LottoNo lottoNo = new LottoNo(number);
			lottoNumbers.add(lottoNo);
		}
		bonusNo = new LottoNo(bonusNumber);
		validateNumbers();
	}

	private void validateNumbers() {
		if (lottoNumbers.size() != NUMBERS_SIZE || lottoNumbers.contains(bonusNo)) {
			throw new IllegalArgumentException("잘못된 번호 모음입니다.");
		}
	}

	public boolean contains(LottoNo lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	public boolean isBonusNumber(LottoNo lottoNo) {
		return bonusNo.equals(lottoNo);
	}
}
