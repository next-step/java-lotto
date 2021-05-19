package step1;

import static org.assertj.core.api.Assertions.*;

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
	@DisplayName(value = "size 메서드가 정상 동작한다.")
	public void checkSize() throws Exception {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName(value = "contains 메서드가 정상 동작한다.")
	public void checkContainsMethod(int element) throws Exception {
		assertThat(numbers.contains(element)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName(value = "contains 메서드가 입력값에 따라 true/false를 반환한다.")
	public void checkContainsMethodDynamic(int element, boolean expected) throws Exception {
		assertThat(numbers.contains(element)).isEqualTo(expected);
	}
}
