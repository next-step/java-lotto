package lotto.domain;

import java.util.List;
import lotto.enums.Prize;

public class WinningLotto extends Lotto {

	private int bonusNumber;

	public WinningLotto(List<Integer> numbers, int bonusNumber) {
		super(numbers);
		this.bonusNumber = bonusNumber;
	}

	public Prize getPrize(Lotto lotto) {
		return Prize.of(super.match(lotto), hasBonusNumber(lotto));
	}

	private boolean hasBonusNumber(Lotto lotto) {
		return lotto.hasNumber(bonusNumber);
	}
}
