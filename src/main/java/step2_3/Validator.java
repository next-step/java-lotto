package step2_3;

import step2_3.domain.Lotto;

import java.util.HashSet;
import java.util.Set;

public class Validator {
	private static final int MAX_LOTTO_VALUE = 45;
	private static final int MAX_LOTTO_NUMBER = 6;

	private Validator() {}

	public static int validPrice(int price) {
		if (price == 0 || price % 1000 != 0) {
			throw new IllegalArgumentException("로또 구입 금액은 1000원 단위만 가능합니다.");
		}
		return price;
	}

	public static Lotto validWinningNumbers(Lotto lotto) {
		Set<Integer> duplicateNumber = new HashSet<>(lotto.getNumbers());
		if (duplicateNumber.size() != MAX_LOTTO_NUMBER || duplicateNumber.stream().anyMatch(n -> n > MAX_LOTTO_VALUE)) {
			throw new IllegalArgumentException("로또 당첨 번호는 1~45 중 중복되지 않는 여섯 개의 숫자로 이루어져야 합니다.");
		}
		return lotto;
	}

	public static int validBonusBallNumber(Lotto winningLotto, int bonusNumber) {
		if (winningLotto.getNumbers().contains(bonusNumber)) {
			throw new IllegalArgumentException("로또 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
		}
		if (bonusNumber > MAX_LOTTO_VALUE) {
			throw new IllegalArgumentException("로또 보너스 번호는 1~45 중 한 개의 숫자로 이루어져야 합니다.");
		}
		return bonusNumber;
	}

}
