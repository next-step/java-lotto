package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection 학습 테스트")
public class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	// Test Case 구현
	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인한다")
	@Test
	void setSize() {
		int expectSetSize = 3;

		assertThat(numbers.size()).isEqualTo(expectSetSize);
	}

	@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는 경우 True를 반환한다")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void setContain(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("Set의 contains() 메소드를 활용해 존재하지 않는 값인 경우 False를 반환한다")
	@ParameterizedTest
	@CsvSource({ "1,True", "2,True", "3,True", "4,False", "5,False" })
	void setContainNotContain(int input, boolean expected) {
		assertEquals(numbers.contains(input), expected);
	}
}
