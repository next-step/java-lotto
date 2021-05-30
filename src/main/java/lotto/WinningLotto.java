package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

	public static final int CONTAIN_BONUS_LOTTO_COUNT = 7;

	private Lotto lotto;
	private LottoNumber bonusNumber;

	public WinningLotto(List<LottoNumber> numbers, LottoNumber bonusNumber) {
		validate(numbers, bonusNumber);
		this.lotto = new Lotto(numbers);
		this.bonusNumber = bonusNumber;
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lotto.contains(lottoNumber);
	}

	public boolean isMatchBonusNumber(LottoNumber lottoNumber) {
		return bonusNumber.equals(lottoNumber);
	}

	private void validate(List<LottoNumber> numbers, LottoNumber bonusNumber) {
		Set<LottoNumber> set = new HashSet<>(numbers);
		set.add(bonusNumber);
		if(set.size() != CONTAIN_BONUS_LOTTO_COUNT) {
			throw new IllegalArgumentException("보너스 숫자는 당첨 번호와 중복될 수 없습니다.");
		}
	}
}
