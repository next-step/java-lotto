package lotto.game.domain.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.game.exception.IllegalCustomGameCountException;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomGameCountTest {

	@DisplayName("4-1-1-2-1.`validateGenerate()` : 0 이상, 구매가능한 갯수 이하의 자연수인지 검증한다. (게임당 1000원 기준)")
	@ParameterizedTest(name = "{index} - text:[{0}], moneyText:[{1}], exceptedNotThrownException:{1}")
	@Order(1)
	@CsvSource(value = {"-1;10000;false", "0;10000;true", "1;10000;true", "10;10000;true", "45;10000;false", "46;10000;false", "one;10000;false",
		"fortyFive;10;false"}, delimiter = ';')
	void generate(String text, String moneyText, boolean exceptedNotThrownException) {
		//given
		InputText inputText = InputText.generate(text);
		InputText moneyInputText = InputText.generate(moneyText);
		Money money = Money.generate(moneyInputText);

		//when
		if (exceptedNotThrownException) {
			//then - not throw any Exception
			assertThatCode(() -> CustomGameCount.validateGenerate(inputText, money)).doesNotThrowAnyException();
			return;
		}
		//then - throw NumberFormatException
		assertThatThrownBy(() -> CustomGameCount.validateGenerate(inputText, money))
			.isInstanceOfAny(IllegalInputTextException.class, IllegalCustomGameCountException.class);
	}

	@DisplayName("4-1-1-2-2.`generate()` : 0 이상, 구매가능한 갯수 이하의 자연수만 생성 가능하도록 한다.")
	@ParameterizedTest(name = "{index} - text:[{0}], expectedNumber:{1}, moneyText:[{2}], exceptedNotThrownException:{3}")
	@Order(2)
	@CsvSource(value = {"-1;-1;10000;false", "0;0;10000;true", "1;1;10000;true", "45;45;10000;false",
		"46;46;10000;false", "one;1;10000;false", "fortyFive;45;10000;false"}, delimiter = ';')
	void generate(String text, int expectedNumber, String moneyText, boolean exceptedNotThrownException) {
		//given
		InputText inputText = InputText.generate(text);
		InputText moneyInputText = InputText.generate(moneyText);
		Money money = Money.generate(moneyInputText);

		//when
		if (exceptedNotThrownException) {
			//then -
			assertThat(CustomGameCount.generate(inputText, money).count()).isEqualTo(expectedNumber);
			return;
		}
		//then - throw NumberFormatException
		assertThatThrownBy(() -> CustomGameCount.generate(inputText, money).count())
			.isInstanceOfAny(IllegalInputTextException.class, IllegalCustomGameCountException.class);
	}
}
