package wootecam.calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTokenizerTest {

	private DefaultStringTokenizer defaultStringTokenizer;
	private CustomStringTokenizer customStringTokenizer;

	@BeforeEach
	void setup() {
		defaultStringTokenizer = new DefaultStringTokenizer();
		customStringTokenizer = new CustomStringTokenizer();
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3", "1:2:3"})
	@DisplayName("쉼표, 콜론만으로 구분하여 정상적으로 문자열을 나누는지 확인")
	void test_쉼표만_콜론만(String input) {
		List<String> numbers = defaultStringTokenizer.getNumbers(input);
		assertThat(numbers).containsExactly("1", "2", "3");
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2:3", "1:2,3"})
	@DisplayName("쉼표와 콜론이 섞인 구분자로 문자열을 나눴을때 테스트")
	void test_쉼표_또는_콜론구분자(String input) {
		List<String> numbers = defaultStringTokenizer.getNumbers(input);
		assertThat(numbers).containsExactly("1", "2", "3");
	}

	@ParameterizedTest
	@ValueSource(strings = {"//;\n1;2;3", "//_\n1_2_3"})
	@DisplayName("커스텀 구분자로 문자열 분리 테스트")
	void test_커스텀구분자(String input) {
		List<String> numbers = customStringTokenizer.getNumbers(input);
		assertThat(numbers).containsExactly("1", "2", "3");
	}

	@ParameterizedTest
	@ValueSource(strings = {"test", "123"})
	@DisplayName("커스텀 구분자 입력 패턴이 잘못되었을 때 문자열 분리 테스트")
	void test_잘못된_커스텀구분자(String input) {
		assertThatThrownBy(() -> {
			customStringTokenizer.getNumbers(input);
		}).isInstanceOf(RuntimeException.class)
			.hasMessageContaining("입력 패턴을 확인하세요.");
	}
}
