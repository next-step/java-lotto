package lotto;

import java.util.List;

import lotto.input.InputValidator;

public class BonusBall {

	private final int bonusBall;

	private BonusBall(int bonusBall) {
		this.bonusBall = bonusBall;
	}

	public static BonusBall of(String bonusBallString) {
		InputValidator.validateBonusBall(bonusBallString);

		return new BonusBall(Integer.parseInt(bonusBallString));
	}

	public boolean isSameNumberIncluded(List<Integer> lottoNumbers) {
		return lottoNumbers.contains(this.bonusBall);
	}

	public void addInto(List<Integer> lottoNumbers) {
		lottoNumbers.add(bonusBall);
	}
}
