package calculator;

import org.junit.Test;

public class StringNumberTest {

	@Test(expected = IllegalArgumentException.class)
	public void 빈값_검증() {
		String number = "";

		new StringNumber(number);
	}

	@Test(expected = IllegalArgumentException.class)
	public void null값_검증2() {
		String number = null;

		new StringNumber(number);
	}

}
