package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

	@Test
	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트")
	public void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest()
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트")
	public void trueContains(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest()
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하고 4, 5의 값이 존재하지 않는지 확인하는 학습테스트")
	public void trueOrFalseContains(int number, boolean isTrue) {
		assertEquals(numbers.contains(number), isTrue);
	}
}