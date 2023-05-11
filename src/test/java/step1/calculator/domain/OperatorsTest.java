package step1.calculator.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.Test;

import step1.calculator.domain.Operators;

public class OperatorsTest {
	@Test
	void 연산자_컬렉션을_생성한다() {
		assertThat(Operators.from("+", "-", "*", "/").getOperators())
			.hasSize(4);
	}
}
