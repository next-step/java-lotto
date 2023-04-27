package lotto.utils;

import java.util.Random;

import lotto.domain.Lotto;

public class RandomUtils {

	private static final Random random = new Random();

	public static int randomInt() {
		return random.nextInt(Lotto.MAXIMUM_BOUND) + 1;
	}
}
