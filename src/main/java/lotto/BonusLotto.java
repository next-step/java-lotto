package lotto;

import java.util.List;

public class BonusLotto extends LottoNumbers {

	private final LottoNumber bonus;

	public BonusLotto(List<Integer> winnerLottoNumbers, LottoNumber bonus) {
		super(winnerLottoNumbers);
		if (super.contains(bonus)) {
			throw new IllegalArgumentException("우승 번호와 보너스 번호는 겹칠 수 없습니다");
		}
		this.bonus = bonus;
	}

	@Override
	public int sameCount(LottoNumbers pursedLotto) {
		int exceptBonus = super.sameCount(pursedLotto);
		if (!pursedLotto.contains(this.bonus)) {
			return exceptBonus;
		}
		return exceptBonus + 1;
	}

}
