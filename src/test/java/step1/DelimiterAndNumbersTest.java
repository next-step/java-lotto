package step1;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterAndNumbersTest {

	@Test
	void testConstruction() {
		DelimiterAndNumbers given = new DelimiterAndNumbers("//;\\n1;2;3");

		Pattern expectPattern = Pattern.compile(";");
		String[] expectNumbers = new String[]{"1","2","3"};

		assertThat(given).isEqualTo(new DelimiterAndNumbers(expectPattern, expectNumbers));
	}

}