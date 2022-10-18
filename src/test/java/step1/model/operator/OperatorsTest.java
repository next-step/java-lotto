package step1.model.operator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorsTest {
	private final Operators operators = new Operators();

	@DisplayName("연산자로 변환 가능한 문자열 개수와 Operator 개수는 같다")
	@Test
	void Given_operator_Then_CreateOperator() {
		List<String> strings = List.of(new String[] {"+", "-"});
		Operators result = operators.convertToOperators(strings);
		assertThat(result).hasSize(strings.size());
	}
}