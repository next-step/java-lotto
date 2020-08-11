package step1.domain;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterAndNumbersTest {

	@Test
	void testConstruction() {
		DelimiterAndNumbers given = new DelimiterAndNumbers("//;\\n1;2;3");

		Pattern expectPattern = Pattern.compile(";");
		int[] expectNumbers = new int[]{1,2,3};

		assertThat(given).isEqualTo(new DelimiterAndNumbers(expectPattern, expectNumbers));
	}

}