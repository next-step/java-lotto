package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
		numbers.add(1);	numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("Set 컬렉션에 중복을 제외한 크기 확인")
	public void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("Set 컬렉션에 Element 포함여부 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void contains(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("Set 컬렉션에 Element 포함여부 확인")
	@ParameterizedTest
	@CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
	public void charAt1(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}

}
