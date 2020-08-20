package step2;

import step2.domain.Lotto;

import java.util.HashSet;
import java.util.Set;

public class Validator {
	private static final int MAX_LOTTO_NUMBER = 6;

	private Validator() {}

	public static int validPrice(int price) {
		if (price % 1000 != 0) {
			throw new IllegalArgumentException("로또 구입 금액은 1000원 단위만 가능합니다.");
		}
		return price;
	}

	public static Lotto validWinningNumbers(Lotto lotto) {
		Set<Integer> duplicateNumber = new HashSet<>();
		duplicateNumber.addAll(lotto.getNumbers());
		if (duplicateNumber.size() != MAX_LOTTO_NUMBER || duplicateNumber.stream().anyMatch(n -> n > 45)) {
			throw new IllegalArgumentException("로또 당첨 번호는 1~45 중 중복되지 않는 6개의 숫자로 이루어져야 합니다.");
		}
		return lotto;
	}

}
