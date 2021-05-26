package lotto.io.domain.aggregate;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextListException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InputTextGroupTest {

	private List<InputText> makeInputTextList(String text) {
		List<InputText> texts = new ArrayList<>();
		for (String splitText : text.split(InputText.COMMA_DELIMITER)) {
			texts.add(InputText.generate(splitText));
		}
		return texts;
	}

	@DisplayName("4-2-1-2-1.`generate()` : InputTextGroup를 생성한다.")
	@ParameterizedTest(name = "{index} - text:[{0}], compareText:[{1}], expectedIsEqual:{2}")
	@Order(1)
	@CsvSource(value = {"0,1,2,3,4,5;0,1,2,3,4,5;true", "1,2,3;2,3,4;false", "5,4,3,2,1;1,2,3,4,5;false",
		"1,2,3;1, 2, 3;true", "one,two;1,2;false"}, delimiter = ';')
	void generate(String text, String compareText, boolean expectedIsEqual) {
		//given
		List<InputText> texts = makeInputTextList(text);
		List<InputText> compareTexts = makeInputTextList(compareText);

		//when
		if (expectedIsEqual) {
			//then - equal
			assertThat(InputTextGroup.generate(texts).inputTexts()).containsSequence(compareTexts);
			return;
		}
		//then - not equal
		assertThat(InputTextGroup.generate(texts).inputTexts()).doesNotContainSequence(compareTexts);
	}

	@DisplayName("4-2-1-2-1.generate() - throw IllegalInputTextException, IllegalInputTextListException")
	@Test
	@Order(2)
	void generateWithExceptions() {
		//given
		List<InputText> nullList = null;
		List<InputText> emptyList = new ArrayList<>();

		//when

		//then
		assertThatThrownBy(() -> InputTextGroup.generate(nullList).inputTexts())
			.isInstanceOfAny(IllegalInputTextListException.class);
		assertThatThrownBy(() -> InputTextGroup.generate(emptyList).inputTexts())
			.isInstanceOfAny(IllegalInputTextListException.class);
	}
}
