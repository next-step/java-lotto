package lotto.game.domain.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.game.exception.IllegalMoneyException;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MoneyTest {

	@DisplayName("4-1-2-6-1.validate() : 돈 유효성 체크(0 이상)")
	@ParameterizedTest(name = "{index} - text:[{0}], exceptedNotThrownException:{1}")
	@Order(1)
	@CsvSource(value = {"-1;false", "0;true", "1000;true", "100000;true", "one;false",
			"fortyFive;false"}, delimiter = ';')
	void validateGenerate(String text, boolean exceptedNotThrownException) {
		//given
		InputText inputText = InputText.generate(text);

		//when
		if (exceptedNotThrownException) {
			//then - not throw any Exception
			assertThatCode(() -> Money.validateGenerate(inputText)).doesNotThrowAnyException();
			return;
		}
		//then - throw NumberFormatException
		assertThatThrownBy(() -> Money.validateGenerate(inputText))
			.isInstanceOfAny(IllegalInputTextException.class, IllegalMoneyException.class);
	}

	@DisplayName("4-1-2-6-2.generate() : 돈 생성")
	@ParameterizedTest(name = "{index} - text:[{0}], exceptedNotThrownException:{1}")
	@Order(2)
	@CsvSource(value = {"-1;false", "0;true", "1000;true", "100000;true", "one;false",
			"fortyFive;false"}, delimiter = ';')
	void generate(String text, boolean exceptedNotThrownException) {
		//given
		InputText inputText = InputText.generate(text);

		//when
		if (exceptedNotThrownException) {
			//then - not throw any Exception
			assertThatCode(() -> Money.generate(inputText)).doesNotThrowAnyException();
			return;
		}
		//then - throw NumberFormatException
		assertThatThrownBy(() -> Money.generate(inputText))
			.isInstanceOfAny(IllegalInputTextException.class, IllegalMoneyException.class);
	}

	@DisplayName("4-1-2-6-3.countOfGames() : 입력된 금액에서 구매할 수 있는 게임의 수")
	@ParameterizedTest(name = "{index} - text:[{0}], exceptedNotThrownException:{1}")
	@Order(3)
	@CsvSource(value = {"0;0;true", "999;0;true", "1000;1;true", "100000;100;true",
		"1500;1;true"}, delimiter = ';')
	void countOfGames(String text, int expectedCount, boolean exceptedNotThrownException) {
		//given
		InputText inputText = InputText.generate(text);

		//when
		if (exceptedNotThrownException) {
			//then - not throw any Exception
			assertThat(Money.generate(inputText).countOfGames()).isEqualTo(expectedCount);
			return;
		}
		//then - throw NumberFormatException
		assertThatThrownBy(() -> Money.generate(inputText))
			.isInstanceOfAny(IllegalMoneyException.class);
	}
}
