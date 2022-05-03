package lotto.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

	private static final Random RANDOM = ThreadLocalRandom.current();

	public static int createRandomNumber(int min, int max) {
		return RANDOM.nextInt(min + max) + min;
	}
}
