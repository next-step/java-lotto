package lotto;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lotto.input.InputValidator;

public class BonusBall {

	private final int bonusBall;

	private BonusBall(int bonusBall) {
		this.bonusBall = bonusBall;
	}

	public static BonusBall of(String bonusBallString) {
		if (StringUtils.isBlank(bonusBallString)) {
			throw new IllegalArgumentException("보너스볼을 입력하셔야 합니다.");
		}
		if (!InputValidator.isNumber(bonusBallString)) {
			throw new IllegalArgumentException("보너스볼은 숫자로 입력하셔야 합니다.");
		}

		return new BonusBall(Integer.parseInt(bonusBallString));
	}

	public boolean isSameNumberIncludedIn(Lotto lotto) {
		return lotto.isSameNumberIncludedWith(this.bonusBall);
	}

	public void addInto(List<Integer> lottoNumbers) {
		lottoNumbers.add(bonusBall);
	}
}
