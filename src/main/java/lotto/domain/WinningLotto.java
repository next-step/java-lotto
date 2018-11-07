package lotto.domain;

import java.util.List;
import lotto.enums.Prize;

public class WinningLotto extends Lotto {

	private int bonusNumber;

	public WinningLotto(List<Integer> numbers, int bonusNumber) {
		super(numbers);
		this.bonusNumber = bonusNumber;
	}

	@Override
	public Prize match(Lotto lotto) {
		Prize prize = super.match(lotto);
		if(prize.equals(Prize.MATCH5)) {
			return matchBonusNumber(lotto);
		}
		return prize;
	}

	private Prize matchBonusNumber(Lotto lotto) {
		if(lotto.hasNumber(bonusNumber)) {
			return Prize.MATCH5;
		}
		return Prize.MATCH4;
	}
}
