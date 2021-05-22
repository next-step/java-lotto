package study.step2.domain.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InputTextTest {
	@DisplayName("4-2-2-2-1.split() : 쉼표구분자 또는 콜론 구분자")
	@ParameterizedTest(name = "{index} - text : {0}")
	@Order(1)
	@CsvSource(value = {"1,2|1,2|true", "1:2|1,2|true", "1,2:3|1,2,3|true",
		"12,12:12|12,12,12|true", "12;12|12,12|false"}, delimiter = '|')
	void split(String text, String expectedStringArrText, boolean exceptedResult) {
		//given
		String[] expectedStringArr = expectedStringArrText.split(",");

		//when
		if (exceptedResult) {
			//then - true
			assertThat(InputText.split(text)).containsExactly(expectedStringArr);
			return;
		}
		//then - false
		assertThat(InputText.split(text)).doesNotContainSequence(expectedStringArr);
	}

	@ParameterizedTest(name = "{index} - text : {0}")
	@Order(2)
	@ValueSource(strings = {"//;\n1;2;3"})
	void equal(String text) {
		assertThat("//;\n1;2;3").isEqualTo(text);
	}

	@DisplayName("4-2-2-2-2.split() : 커스텀 구분자")
	@ParameterizedTest(name = "{index} - text : {0}")
	@Order(3)
	@ValueSource(strings = {"//;\n1;2;3!!!1,2,3!!!true", "//;\n1:2,3;4!!!1,2,3,4!!!true", "1,2;3!!!1,2,3!!!false"})
	void splitWithCustomDelimiter(String valueSource) {
		//given
		String[] expectedValues = valueSource.split("!!!");
		String text = expectedValues[0];
		String[] expectedStringArr = expectedValues[1].split(",");
		boolean exceptedResult = Boolean.valueOf(expectedValues[2]);

		//when
		if (exceptedResult) {
			//then - true
			assertThat(InputText.split(text)).containsExactly(expectedStringArr);
			return;
		}
		//then - false
		assertThat(InputText.split(text)).doesNotContainSequence(expectedStringArr);
	}


}
