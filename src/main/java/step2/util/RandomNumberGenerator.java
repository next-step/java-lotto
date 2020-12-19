package step2.util;

import java.util.Random;

public class RandomNumberGenerator {

	public static int getRandomNumber(int boundary) {
		return new Random().nextInt(boundary);
	}

}
