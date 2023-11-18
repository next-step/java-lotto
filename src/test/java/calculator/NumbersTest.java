package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
	@Test
	@DisplayName("plus_push 1,2_3")
	void plus() {
		Numbers numbers = new Numbers(new Stack<>());
		numbers.push(1);
		numbers.push(2);
		numbers.plus();
		assertThat(numbers.pop()).isEqualTo(3);
	}

	@Test
	@DisplayName("minus_push 1,2_1")
	void minus() {
		Numbers numbers = new Numbers(new Stack<>());
		numbers.push(1);
		numbers.push(2);
		numbers.minus();
		assertThat(numbers.pop()).isEqualTo(1);
	}

	@Test
	@DisplayName("multiplication_push 1,2_2")
	void multiplication() {
		Numbers numbers = new Numbers(new Stack<>());
		numbers.push(1);
		numbers.push(2);
		numbers.multiplication();
		assertThat(numbers.pop()).isEqualTo(2);
	}

	@Test
	@DisplayName("division_push 1,2_2")
	void division() {
		Numbers numbers = new Numbers(new Stack<>());
		numbers.push(1);
		numbers.push(2);
		numbers.division();
		assertThat(numbers.pop()).isEqualTo(2);
	}
}
