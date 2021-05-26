package study.step2.domain.aggregate;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.step2.domain.value.InputText;
import study.step2.domain.value.Number;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NumberGroupTest {
	@DisplayName("4-2-3-1-1.parse() : InputText를 Numbergroup으로 파싱")
	@ParameterizedTest(name = "{index} - text : {0}, isNotThrowException : {2}")
	@Order(1)
	@CsvSource(value = {"1,2|1,2|true", "1:2|1,2|true", "1,2:3|1,2,3|true",
		"12,12:12|12,12,12|true", "12;12|12,12|false"}, delimiter = '|')
	void split(String text, String expectedStringArrText, boolean isNotThrowException) {
		//given
		List<Number> expectedNumbers = Arrays.stream(expectedStringArrText.split(","))
			.map(Number::generate)
			.collect(Collectors.toList());

		//when
		if (isNotThrowException) {
			//then
			assertThat(NumberGroup.generate(InputText.split(text)).numbers()).containsSequence(expectedNumbers);
			return;
		}
		//then - throw RuntimeException
		assertThatThrownBy(() -> NumberGroup.generate(InputText.split(text)).numbers())
			.isInstanceOf(RuntimeException.class);
	}

}
