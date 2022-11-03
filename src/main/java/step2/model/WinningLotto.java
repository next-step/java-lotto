package step2.model;

import java.util.List;
import step2.exception.IllegalNumberException;

public class WinningLotto {

	private List<Integer> winLottoNumber;
	private int bonusNumber;


	private WinningLotto(List<Integer> winLottoNumber, int bonusNumber) {
		this.winLottoNumber = winLottoNumber;
		this.bonusNumber = bonusNumber;
	}

	public static WinningLotto of(List<Integer> winLottoNumber, int bonusNumber) {
		if (winLottoNumber.contains(bonusNumber)) {
			throw new IllegalNumberException("보너스 번호는 당첨 번호랑 같을 수 없습니다.");
		}
		return new WinningLotto(winLottoNumber, bonusNumber);
	}

	public int countOfMatch(LottoNumbers lottoNumbers) {
		return (int) winLottoNumber.stream()
			.filter(lottoNumbers::contains)
			.count();
	}

	public boolean isBonus(LottoNumbers lottoNumbers) {
		return lottoNumbers.contains(bonusNumber);
	}
}



