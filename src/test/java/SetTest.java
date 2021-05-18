import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	void sizeTest() {
		int size = numbers.size();
		assertThat(size).isEqualTo(3);
	}

	@ParameterizedTest
	@CsvSource(value = {"1", "2", "3"})
	void containsTest(int expect) {
		assertThat(numbers.contains(expect)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void containsTest2(int value, boolean result) {

		assertThat(numbers.contains(value)).isEqualTo(result);
	}
}
