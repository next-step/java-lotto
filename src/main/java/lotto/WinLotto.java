package lotto;

import java.util.List;

public final class WinLotto {
	private final Lotto lotto;
	private final LottoNo bonusNo;

	public WinLotto(List<Integer> numbers, int bonusNumber) {
		if (numbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("잘못된 번호 모음입니다.");
		}
		lotto = new Lotto(numbers);
		bonusNo = new LottoNo(bonusNumber);
	}

	public boolean contains(LottoNo lottoNumber) {
		return lotto.contains(lottoNumber);
	}

	public boolean isBonusNumber(LottoNo lottoNo) {
		return bonusNo.equals(lottoNo);
	}
}
