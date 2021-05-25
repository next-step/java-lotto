package lotto.io.domain.vo;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.exception.IllegalInputTextException;
import lotto.io.exception.IllegalInputTextListException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InputTextTest {

	@DisplayName("4-2-1-1-1.`validate()` : `null`, `empty`의 경우 exception 발생")
	@ParameterizedTest(name = "{index} - text:[{0}], expectedDoesNotThrowAnyException:{1}")
	@Order(1)
	@CsvSource(value = {"0,1,2,3,4,5;true", "1,2,3;true", "5,4,3,2,1;true",
		"1, 2, 3;true", "one,two;true", "' ';false", ";false"}, delimiter = ';')
	void validate(String text, boolean expectedDoesNotThrowAnyException) throws IllegalInputTextException {
		//given

		//when
		if (expectedDoesNotThrowAnyException) {
			//then
			assertThatCode(() -> InputText.validateGenerate(text)).doesNotThrowAnyException();
			return;
		}
		//then - throw IllegalInputTextException
		assertThatThrownBy(() -> InputText.validateGenerate(text)).isInstanceOf(IllegalInputTextException.class);
	}

	private InputTextGroup makeInputTextGroup(String text) throws
			IllegalInputTextException, IllegalInputTextListException {
		List<InputText> texts = new ArrayList<>();
		for (String splitText : text.split(InputText.COMMA_DELIMITER)) {
			texts.add(InputText.generate(splitText));
		}
		return InputTextGroup.generate(texts);
	}

	@DisplayName("4-2-1-1-2.`generate()` : `null`, `empty`의 경우 exception 발생")
	@ParameterizedTest(name = "{index} - text : [{0}]")
	@Order(2)
	@ValueSource(strings = {"", " "})
	@NullSource
	void generate(String str) {
		//given

		//when

		//then
		assertThatThrownBy(() -> InputText.generate(str)).isInstanceOf(IllegalInputTextException.class);
	}

	@DisplayName("4-2-1-1-3.`splitByComma()` : 쉼표`,`를 구분자로 사용한다. `trim()`을 활용하여 공백을 제거한 InputText의 리스트로 리턴한다.")
	@ParameterizedTest(name = "{index} - text:[{0}], compareText:[{1}], expectedIsEqual:{2}")
	@Order(3)
	@CsvSource(value = {"0,1,2,3,4,5;0,1,2,3,4,5;true", "1,2,3;2,3,4;false", "5,4,3,2,1;1,2,3,4,5;false",
		"1,2,3;1, 2, 3;true", "one,two;1,2;false"}, delimiter = ';')
	void validate(String text, String compareText, boolean expectedIsEqual) throws
			IllegalInputTextException, IllegalInputTextListException {
		//given
		InputTextGroup compareTexts = makeInputTextGroup(compareText);

		//when
		if (expectedIsEqual) {
			//then - equal
			assertThat(InputText.generate(text).splitByComma().inputTexts())
				.containsSequence(compareTexts.inputTexts());
			return;
		}
		//then - not equal
		assertThat(InputText.generate(text).splitByComma().inputTexts())
			.doesNotContainSequence(compareTexts.inputTexts());
	}
}
