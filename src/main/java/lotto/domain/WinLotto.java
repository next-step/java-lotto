package lotto.domain;

import java.util.List;

public class WinLotto {
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 45;

	private final List<Integer> winLotto;
	private final int bonus;

	public WinLotto(List<Integer> winLotto, int bonus) {
		validateLotto(winLotto);
		validateBonus(bonus);
		this.winLotto = winLotto;
		this.bonus = bonus;
	}

	public List<Integer> getWinLotto() {
		return winLotto;
	}

	public int getBonus() {
		return bonus;
	}

	private void validateBonus(int bonus) {
		if (bonus < LOTTO_START_NUMBER || bonus > LOTTO_END_NUMBER) {
			throw new IllegalArgumentException("1부터 45사이 번호만 입력 가능합니다.");
		}
	}

	private void validateLotto(List<Integer> lotto) {
		if (lotto == null) {
			throw new IllegalArgumentException("로또 번호를 입력하지 않았습니다.");
		}

		boolean isValid = lotto.stream()
			.anyMatch(number -> number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER);
		if (isValid) {
			throw new IllegalArgumentException("1부터 45사이 번호만 입력 가능합니다.");
		}
	}
}
