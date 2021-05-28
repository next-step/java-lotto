package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

	public static final int MAX_LOTTO_COUNT = 6;
	public static final int CONTAIN_BONUS_LOTTO_COUNT = 7;

	private List<LottoNumber> lottoNumbers;
	private LottoNumber bonusNumber;

	public WinningLotto(List<LottoNumber> numbers, LottoNumber bonusNumber) {
		validate(numbers, bonusNumber);
		this.lottoNumbers = numbers;
		this.bonusNumber = bonusNumber;
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	public boolean isMatchBonusNumber(LottoNumber lottoNumber) {
		return bonusNumber.equals(lottoNumber);
	}

	private void validate(List<LottoNumber> numbers, LottoNumber bonusNumber) {
		if(numbers.size() != MAX_LOTTO_COUNT) {
			throw new IllegalArgumentException("로또 숫자가 6개가 아닙니다.");
		}

		Set<LottoNumber> set = new HashSet<>(numbers);
		if(set.size() != MAX_LOTTO_COUNT) {
			throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
		}

		set.add(bonusNumber);
		if(set.size() != CONTAIN_BONUS_LOTTO_COUNT) {
			throw new IllegalArgumentException("보너스 숫자는 당첨 번호와 중복될 수 없습니다.");
		}
	}
}
