package lotto.game.domain.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.game.domain.aggregate.BallGroup;
import lotto.game.domain.aggregate.GameGroup;
import lotto.game.domain.vo.Game;
import lotto.game.domain.vo.Money;
import lotto.game.exception.IllegalBonusBallException;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.vo.InputText;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoundTest {

	@Test
	@DisplayName("4-1-3-1-1.Field 생성 : `GameWinningCondition")
	void setupGameWinningCondition() {
		//given
		String systemIn = "12,13,14,15,16,17";
		boolean expectedIsEqual = true;

		//when
		InputText inputText = InputText.generate(systemIn);
		InputTextGroup inputTextGroup = inputText.splitByComma();
		BallGroup ballGroup = BallGroup.generate(inputTextGroup);
		Game gameWinningCondition = Game.generateCustom(ballGroup);

		Round round = Round.generate().setupGameWinningCondition(inputText);

		//then
		assertThat(round.gameWinningCondition().isContainSameBalls(gameWinningCondition)).isEqualTo(expectedIsEqual);
	}

	@DisplayName("4-1-3-1-1.Field 생성 : `GameGroup`, `Money")
	@ParameterizedTest(name = "{index} - text:[{0}], exceptedNotThrownException:{1}")
	@CsvSource(value = {"1000;1", "100000;100", "1500;1"}, delimiter = ';')
	void raiseMoney(String moneyText, int gameSize) {
		//given

		//when
		InputText moneyInputText = InputText.generate(moneyText);
		Money money = Money.generate(moneyInputText);
		GameGroup boughtGame = GameGroup.buyGames(money);

		Round round = Round.generate();
		round.raiseMoney(money);
		round.setupBoughtGames(boughtGame);

		//then
		assertThat(round.money().amount()).isEqualTo(money.amount());
		assertThat(round.boughtGames().games().size()).isEqualTo(gameSize);
	}

	@DisplayName("4-1-3-1-1.Field 생성 : `bonusBall : Ball`")
	@ParameterizedTest(name = "{index} - winningConditionText:{0}, bonusBallText:{1}, expectedNotThrowException:{2}")
	@CsvSource(value = {"1,2,3,4,5,6;1;false", "6,5,4,3,2,1;2;false", "1,2,3,3,4,5,6;7;true",
		"1, 21, 31, 45, 41, 11;45;false"}, delimiter = ';')
	void setupBonusBall(String winningConditionText, String bonusBallText, boolean expectedNotThrowException) {
		//given
		InputText winningConditionInputText = InputText.generate(winningConditionText);

		InputText inputText = InputText.generate(bonusBallText);

		//when
		Round round = Round.generate().setupGameWinningCondition(winningConditionInputText);

		//then
		if (expectedNotThrowException) {
			assertThatCode(() -> round.setupBonusBall(inputText)).doesNotThrowAnyException();
			return;
		}
		assertThatThrownBy(() -> round.setupBonusBall(inputText)).isInstanceOf(IllegalBonusBallException.class);
	}

}
