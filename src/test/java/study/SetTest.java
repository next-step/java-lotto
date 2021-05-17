package study;

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

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("Set_값_포함여부_ParameterizedTest_CsvSource_사용_테스트")
	void containsNumber_useParameterizedTestAndCsvSource_test(int value, boolean result) {
		assertThat(numbers.contains(value)).isEqualTo(result);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set_값_포함여부_ParameterizedTest_ValueSource_사용_테스트")
	void containsNumber_useParameterizedTestAndValueSource_test(int value) {
		assertThat(numbers.contains(value)).isTrue();
	}

	@Test
	@DisplayName("Set_크기확인_테스트")
	void getSize_test() {
		assertThat(numbers.size()).isEqualTo(3);
	}
}
