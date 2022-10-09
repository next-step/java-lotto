package step1;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SeparatorTest {
	@Test
	@DisplayName("식 받아서 숫자/기호 분리")
	void separateNumbers() {
		Separator separator = new Separator("1 + 2 + 3");
		assertThat(separator.getFormula()).isEqualTo(Arrays.asList("1", "+", "2", "+", "3"));
	}
}
