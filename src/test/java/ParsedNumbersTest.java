import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ParsedNumbersTest {
	@Test
	void sumTest() {
		ParsedNumbers numbers = new ParsedNumbers(Arrays.asList(new ParsedNumber("1"), new ParsedNumber("2")));
		assertThat(numbers.sum()).isEqualTo(3);
	}
}
