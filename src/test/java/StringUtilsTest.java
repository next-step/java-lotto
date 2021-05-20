import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringUtilsTest {

	@ParameterizedTest(name = "입력받은 구분자를 기준으로 문자열 split 테스트. delimter={0}, text={1}")
	@CsvSource(value = {
		";$1;2;3", "@$1@2@3", ",$1,2,3"
	}, delimiter = '$')
	void splitTest(final String delimiter, final String text){
		assertThat(StringUtils.split(delimiter, text))
			.containsExactly("1", "2", "3");
	}

	@ParameterizedTest(name = "split이 불가능한 테스트 케이스. delimiter={0}, text={1}")
	@CsvSource(value = {
		"$", "$1;2;3", ";$"
	}, delimiter = '$')
	void splitTestFailedTest(final String delimiter, final String text){
		assertThat(StringUtils.split(delimiter, text))
			.isNull();
	}

	@Test
	@DisplayName("문자를 숫자로 변환하여 총합을 구하는 기능 테스트")
	void sum(){
		String[] texts = {"1", "2", "3"};
		assertThat(StringUtils.sumWithOutNegative(texts))
			.isEqualTo(6);
	}

	@ParameterizedTest(name = "Sum, int로 변환이 불가능한 케이스 테스트. value={0}")
	@MethodSource("parameterForSumWithNullAndEmpty")
	void sumWithNullAndEmpty(String[] texts){
		assertThatExceptionOfType(NumberFormatException.class)
			.isThrownBy(()->StringUtils.sumWithOutNegative(texts));
	}

	private static Stream<Arguments> parameterForSumWithNullAndEmpty(){
		return Stream.of(
			Arguments.of((Object) new String[]{"1", "", "3"}), 		// 빈값
			Arguments.of((Object) new String[]{"1", null, "3"}),	// null
			Arguments.of((Object) new String[]{"1", "$2", "3"}) 	// 숫자가 아닌 형태
						);
	}

	@Test
	@DisplayName("Sum, 음수가 포함된 케이스 테스트")
	void sumWithNagative(){
		// given
		String[] texts = {"1", "-2", "3"};

		// when
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(()->StringUtils.sumWithOutNegative(texts));
	}
}
