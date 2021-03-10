package camp.nextcamp.edu.lotto.module;

import static camp.nextcamp.edu.lotto.constants.LottoConstants.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoValidator {

	private LottoValidator() {
	}

	public static boolean isInRange(int number) {
		return LOTTO_MIN <= number && number <= LOTTO_MAX;
	}
}
