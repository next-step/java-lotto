package stringcalculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

	@DisplayName("사칙연산 입력값 예외 테스트")
	@Test
	void test1() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Operator(">"));
	}
}
