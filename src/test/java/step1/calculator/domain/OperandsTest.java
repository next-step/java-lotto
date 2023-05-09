package step1.calculator.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.Test;

public class OperandsTest {
	@Test
	void 피연산자_컬렉션을_생성한다() {
		assertThat(Operands.from("1", "2", "3").getOperands())
			.hasSize(3);
	}
}
