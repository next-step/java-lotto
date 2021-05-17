import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

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
	@DisplayName("size() 메서드는 집합의 크기를 반환한다.")
	public void sizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("contains() 메서드는 집합에 값이 존재한다면 True 를 반환한다.")
	public void containsTrueTest(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
	@DisplayName("contains() 메서드는 집합에 값이 존재하면 True 아니면 False 를 반환한다.")
	public void containsTest(String input, boolean expected) {
		List<Integer> inputNumbers = mapToIntegers(input);

		assertContainNumbers(inputNumbers, expected);
	}

	private List<Integer> mapToIntegers(String input) {
		return Stream.of(input.split(","))
			.map(Integer::parseInt)
			.collect(toList());
	}

	private void assertContainNumbers(List<Integer> inputNumbers, boolean expected) {
		for (Integer number : inputNumbers) {
			assertThat(numbers.contains(number)).isEqualTo(expected);
		}
	}

}
