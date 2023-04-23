package lotto.utils;

import java.util.Random;

public class RandomUtils {

	private static final Random random = new Random();
	private static final int MAX_BOUND = 45;

	public static int randomInt() {
		return random.nextInt(MAX_BOUND) + 1;
	}
}
