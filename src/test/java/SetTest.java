import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
	public void sizeTest() {
		int actualSize = numbers.size();
		assertThat(actualSize).isEqualTo(3);
	}

	@ParameterizedTest(name = "[{index}] contains 테스트 {0}값이 존재하면 True를 반환한다")
	@ValueSource(ints = {1, 2, 3})
	public void setTest2(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest(name = "[{index}] contains 테스트 {0}는 {1}를 반환해야 한다")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	public void setTest3(int input, boolean expected) {
		boolean actual = numbers.contains(input);
		assertThat(actual).isEqualTo(expected);
	}
}
