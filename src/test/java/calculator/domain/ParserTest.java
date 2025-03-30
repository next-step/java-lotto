package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
	@Test
	@DisplayName("공백을 기준으로 문자열을 자른다.")
	void splitStringTest() {
		Parser parser = new Parser();
		String input = "  2 +  3 * 4";
		String[] expected = {"2", "+", "3", "*", "4"};

		String[] result = parser.splitString(input);

		assertArrayEquals(result, expected);
	}

	@Test
	@DisplayName("짝수번째 인덱스에 위치한 숫자를 Operand 객체로 변환한다.")
	void parseOperandTest() {
		Parser parser = new Parser();
		String[] tokens = {"2", "+", "3", "*", "4"};
		List<Operand> expected = List.of(new Operand(2), new Operand(3), new Operand(4));
		List<Operand> result = parser.parseOperand(tokens);

		assertEquals(result.size(), expected.size());
		for (int i = 0; i < result.size(); i++) {
			assertEquals(result.get(i)
				.getNumber(), expected.get(i)
				.getNumber());
		}
	}

	@Test
	@DisplayName("홀수번째 인덱스에 위치한 연산자를 Operator 객체로 변환한다.")
	void parseOperatorTest() {
		Parser parser = new Parser();
		String[] tokens = {"2", "+", "3", "*", "4"};
		List<Operator> expected = List.of(Operator.ADD, Operator.MULTIPLY);
		List<Operator> result = parser.parseOperator(tokens);

		assertEquals(result.size(), expected.size());
		for (int i = 0; i < result.size(); i++) {
			assertEquals(result.get(i), expected.get(i));
		}
	}

}
