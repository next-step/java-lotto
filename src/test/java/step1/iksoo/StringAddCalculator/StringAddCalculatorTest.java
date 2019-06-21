package step1.iksoo.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
	private StringAddCalculator cal;

	@BeforeEach
	public void setUp() {
		cal = new StringAddCalculator();
	}

	@Test
	public void add_null_또는_빈문자() throws Exception {
		assertThat(cal.add(null)).isEqualTo(0);
	}
}
