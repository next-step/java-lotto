package lotto.game.domain.aggregate;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.game.domain.vo.Money;
import lotto.game.exception.IllegalMoneyAmountException;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextException;
import lotto.io.exception.IllegalInputTextGroupException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameGroupTest {

	@DisplayName("4-1-2-4-1.`buyGames()` : 금액에 따라 여러 개의 게임을 생성한다.")
	@ParameterizedTest(name = "{index} - moneyAmountText:[{0}], gameCount:{1}, exceptedNotThrownException:{2}")
	@Order(1)
	@CsvSource(value = {"0;0;false", "999;0;false", "1000;1;true", "100000;100;true",
			"1500;1;true"}, delimiter = ';')
	void buyGames(String moneyAmountText, int gameCount, boolean exceptedNotThrownException) throws
		IllegalInputTextException, IllegalMoneyAmountException, IllegalInputTextGroupException {
		//given
		InputText inputText = InputText.generate(moneyAmountText);
		Money money = Money.generate(inputText);

		//when
		if (exceptedNotThrownException) {
			//then - not throw any Exception
			assertThat(GameGroup.buyGames(money).games().size()).isEqualTo(gameCount);
			return;
		}
		//then - throw IllegalMoneyAmountException
		assertThatThrownBy(() -> GameGroup.buyGames(money))
			.isInstanceOfAny(IllegalMoneyAmountException.class);
	}

	@DisplayName("4-1-2-4-2.`makeMsgAllGames()` : 모든 게임의 정보를 메시지로 작성한다.")
	@ParameterizedTest(name = "{index} - moneyAmountText:[{0}], gameCount:{1}, exceptedNotThrownException:{2}")
	@Order(2)
	@CsvSource(value = {"0;0;false", "999;0;false", "1000;1;true", "100000;100;true",
			"1500;1;true"}, delimiter = ';')
	void makeMsgAllGames(String moneyAmountText, int gameCount, boolean exceptedNotThrownException) throws
			IllegalInputTextException, IllegalMoneyAmountException, IllegalInputTextGroupException {
		//given
		InputText inputText = InputText.generate(moneyAmountText);
		Money money = Money.generate(inputText);

		//when
		if (exceptedNotThrownException) {
			//then - not throw any Exception
			GameGroup gameGroup = GameGroup.buyGames(money);
			assertThat(gameGroup.games().size()).isEqualTo(gameCount);
			System.out.println(gameGroup.makeMsgAllGames());
			return;
		}
		//then - throw IllegalMoneyAmountException
		assertThatThrownBy(() -> GameGroup.buyGames(money))
			.isInstanceOfAny(IllegalMoneyAmountException.class);
	}
}
