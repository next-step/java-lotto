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
import lotto.game.domain.vo.GameWinningCondition;
import lotto.game.domain.vo.Money;
import lotto.game.exception.IllegalBallGroupException;
import lotto.game.exception.IllegalBallNumberException;
import lotto.game.exception.IllegalGameException;
import lotto.game.exception.IllegalMoneyAmountException;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextException;
import lotto.io.exception.IllegalInputTextGroupException;
import lotto.io.exception.IllegalInputTextListException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoundTest {

	@Test
	@DisplayName("4-1-3-1-1.Field 생성 : `GameWinningCondition")
	void setupGameWinningCondition() throws
			IllegalInputTextException,
			IllegalInputTextListException,
			IllegalBallNumberException,
			IllegalInputTextGroupException,
			IllegalBallGroupException,
			IllegalGameException {
		//given
		String systemIn = "12,13,14,15,16,17";
		boolean expectedIsEqual = true;

		//when
		InputText inputText = InputText.generate(systemIn);
		InputTextGroup inputTextGroup = inputText.splitByComma();
		BallGroup ballGroup = BallGroup.generate(inputTextGroup);
		Game customGame = Game.generateCustom(ballGroup);
		GameWinningCondition gameWinningCondition = GameWinningCondition.generate(customGame);

		Round round = Round.generate().setupGameWinningCondition(inputText);

		//then
		assertThat(round.gameWinningCondition().isSameWinningCondition(gameWinningCondition)).isEqualTo(expectedIsEqual);
	}

	@DisplayName("4-1-3-1-1.Field 생성 : `GameGroup`, `Money")
	@ParameterizedTest(name = "{index} - text:[{0}], exceptedNotThrownException:{1}")
	@CsvSource(value = {"1000;1", "100000;100", "1500;1"}, delimiter = ';')
	void raiseMoney(String moneyText, int gameSize) throws
			IllegalInputTextException,
			IllegalInputTextGroupException,
			IllegalMoneyAmountException {
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

}
