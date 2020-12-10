package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SeparatedInputValuesTest {

	@DisplayName("분리된 문자를 모두 덧셈 할수 있다.")
	@Test
	void SUM_TEST() {
		List<String> strings = new ArrayList<>();
		strings.add("10");
		strings.add("20");
		strings.add("30");

		assertThat(new SeparatedInputValues(strings).sum()).isEqualTo(60);
	}
}
