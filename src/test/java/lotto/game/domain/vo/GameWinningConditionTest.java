package lotto.game.domain.vo;

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

import lotto.game.domain.aggregate.BallGroup;
import lotto.game.domain.aggregate.GameGroup;
import lotto.game.domain.entity.Round;
import lotto.game.exception.GameContextIllegalParameterException;
import lotto.game.exception.IllegalBallGroupException;
import lotto.game.exception.IllegalBallNumberException;
import lotto.game.exception.IllegalGameException;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextException;
import lotto.io.exception.IllegalInputTextGroupException;
import lotto.io.exception.IllegalInputTextListException;
import lotto.io.exception.IoContextIllegalParameterException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameWinningConditionTest {
	@DisplayName("4-1-2-5-1.`generate()` : 게임 당첨 조건을 생성한다.")
	@ParameterizedTest(name = "{index} - text:[{0}], exceptedNotThrownException:{1}")
	@Order(1)
	@CsvSource(value = {"1,2,3,4,5, 6;true", "7,8,9,10,11,25;true", "12,13,14,15,16,17;true",
		"19,19,20,20,21,22,23,24;true"}, delimiter = ';')
	void validateGenerate(String text, boolean exceptedNotThrownException) throws
			IllegalInputTextException, IllegalInputTextListException,
			IllegalBallNumberException, IllegalInputTextGroupException, IllegalBallGroupException {
		//given
		InputText inputText = InputText.generate(text);
		InputTextGroup inputTextGroup = inputText.splitByComma();
		BallGroup ballGroup = BallGroup.generate(inputTextGroup);
		Game customGame = Game.generateCustom(ballGroup);

		//when
		if (exceptedNotThrownException) {
			//then - not throw any Exception
			assertThatCode(() -> GameWinningCondition.validateGenerate(customGame)).doesNotThrowAnyException();
			return;
		}
		//then - throw NumberFormatException
		assertThatThrownBy(() -> GameWinningCondition.validateGenerate(customGame))
			.isInstanceOfAny(IllegalBallGroupException.class);
	}

	@DisplayName("4-1-2-5-1.`generate()` : 게임 당첨 조건을 생성한다.")
	@Test
	@Order(2)
	void validateGenerateWithNull() {
		//given
		Game nullGame = null;

		//when

		//then - throw NumberFormatException
		assertThatThrownBy(() -> GameWinningCondition.validateGenerate(nullGame))
			.isInstanceOfAny(IllegalGameException.class);
	}

	@DisplayName("4-1-2-5-1.`generate()` : 게임 당첨 조건을 생성한다.")
	@ParameterizedTest(name = "{index} - text:[{0}], exceptedNotThrownException:{1}")
	@Order(3)
	@CsvSource(value = {"1,2,3,4,5, 6;true", "7,8,9,10,11,25;true", "12,13,14,15,16,17;true",
		"19,19,20,20,21,22,23,24;true"}, delimiter = ';')
	void generate(String text, boolean exceptedNotThrownException) throws
			IllegalInputTextException, IllegalInputTextListException,
			IllegalBallNumberException, IllegalInputTextGroupException, IllegalBallGroupException {
		//given
		InputText inputText = InputText.generate(text);
		InputTextGroup inputTextGroup = inputText.splitByComma();
		BallGroup ballGroup = BallGroup.generate(inputTextGroup);
		Game customGame = Game.generateCustom(ballGroup);

		//when

		//then - not throw any Exception
		assertThatCode(() -> GameWinningCondition.generate(customGame)).doesNotThrowAnyException();
	}

	@DisplayName("4-1-2-5-2.`calculateContainWinningBalls()` : 게임 등수를 계산한다.")
	@ParameterizedTest(name = "{index} - text:[{0}], exceptedNotThrownException:{1}, countOfMatch:{2}")
	@Order(3)
	@CsvSource(value = {"1,2,3,4,5,6;1,2,3,4,5,6;6", "1,2,3,4,5,6;2,3,4,5,6,7;5",
		"1,2,3,4,5,6;3,4,5,6,7,8;4", "1,2,3,4,5,6;4,5,6,7,8,9;3", "1,2,3,4,5,6;5,6,7,8,9,10;2",
		"1,2,3,4,5,6;6,7,8,9,10,11;1", "1,2,3,4,5,6;7,8,9,10,11,12;0"}, delimiter = ';')
	void calculateContainWinningBalls(String boughtGameText, String winningConditionText, long countOfMatch) throws
		IllegalInputTextException, IllegalInputTextListException, IllegalBallNumberException,
		IllegalInputTextGroupException, IllegalBallGroupException, IllegalGameException {
		//given
		InputText inputText = InputText.generate(boughtGameText);
		InputTextGroup inputTextGroup = inputText.splitByComma();
		BallGroup ballGroup = BallGroup.generate(inputTextGroup);
		Game boughtGame = Game.generateCustom(ballGroup);

		InputText inputWinningConditionText = InputText.generate(winningConditionText);
		InputTextGroup inputWinningConditionTextGroup = inputWinningConditionText.splitByComma();
		BallGroup winningConditionBallGroup = BallGroup.generate(inputWinningConditionTextGroup);
		Game winningConditionGame = Game.generateCustom(winningConditionBallGroup);

		//when
		GameWinningCondition winningCondition = GameWinningCondition.generate(winningConditionGame);

		//then - not throw any Exception
		assertThat(winningCondition.calculateContainWinningBalls(boughtGame)).isEqualTo(countOfMatch);
	}

	@DisplayName("4-1-2-5-3.`makeMsgWinningStatistics()` : 당첨 통계를 생성한다.")
	@ParameterizedTest(name = "{index} - text:[{0}], exceptedNotThrownException:{1}, countOfMatch:{2}")
	@Order(4)
	@CsvSource(value = {"1,2,3,4,5,6;2,3,4,5,6,7;3,4,5,6,7,8;4,5,6,7,8,9;5,6,7,8,9,10;6,7,8,9,10,11;"
		+ "7,8,9,10,11,12;1,2,3,4,5,6"}, delimiter = ';')
	void makeMsgWinningStatistics(String boughtGame6MatchText, String boughtGame5MatchText,
		String boughtGame4MatchText, String boughtGame3MatchText, String boughtGame2MatchText,
		String boughtGame1MatchText, String boughtGame0MatchText, String winningConditionText) throws
		IllegalInputTextException, IllegalInputTextListException, IllegalBallNumberException,
		IllegalInputTextGroupException, IllegalBallGroupException, IllegalGameException {
		//given
		InputText inputText6Match = InputText.generate(boughtGame6MatchText);
		InputTextGroup inputTextGroup6Match = inputText6Match.splitByComma();
		BallGroup ballGroup6Match = BallGroup.generate(inputTextGroup6Match);
		Game boughtGame6Match = Game.generateCustom(ballGroup6Match);

		InputText inputText5Match = InputText.generate(boughtGame5MatchText);
		InputTextGroup inputTextGroup5Match = inputText5Match.splitByComma();
		BallGroup ballGroup5Match = BallGroup.generate(inputTextGroup5Match);
		Game boughtGame5Match = Game.generateCustom(ballGroup5Match);

		InputText inputText4Match = InputText.generate(boughtGame4MatchText);
		InputTextGroup inputTextGroup4Match = inputText4Match.splitByComma();
		BallGroup ballGroup4Match = BallGroup.generate(inputTextGroup4Match);
		Game boughtGame4Match = Game.generateCustom(ballGroup4Match);

		InputText inputText3Match = InputText.generate(boughtGame3MatchText);
		InputTextGroup inputTextGroup3Match = inputText3Match.splitByComma();
		BallGroup ballGroup3Match = BallGroup.generate(inputTextGroup3Match);
		Game boughtGame3Match = Game.generateCustom(ballGroup3Match);

		InputText inputText2Match = InputText.generate(boughtGame2MatchText);
		InputTextGroup inputTextGroup2Match = inputText2Match.splitByComma();
		BallGroup ballGroup2Match = BallGroup.generate(inputTextGroup2Match);
		Game boughtGame2Match = Game.generateCustom(ballGroup2Match);

		InputText inputText1Match = InputText.generate(boughtGame1MatchText);
		InputTextGroup inputTextGroup1Match = inputText1Match.splitByComma();
		BallGroup ballGroup1Match = BallGroup.generate(inputTextGroup1Match);
		Game boughtGame1Match = Game.generateCustom(ballGroup1Match);

		InputText inputText0Match = InputText.generate(boughtGame0MatchText);
		InputTextGroup inputTextGroup0Match = inputText0Match.splitByComma();
		BallGroup ballGroup0Match = BallGroup.generate(inputTextGroup0Match);
		Game boughtGame0Match = Game.generateCustom(ballGroup0Match);

		List<Game> boughtGames = new ArrayList<>();
		boughtGames.add(boughtGame0Match);
		boughtGames.add(boughtGame1Match);
		boughtGames.add(boughtGame2Match);
		boughtGames.add(boughtGame3Match);
		boughtGames.add(boughtGame4Match);
		boughtGames.add(boughtGame5Match);
		boughtGames.add(boughtGame6Match);

		InputText inputWinningConditionText = InputText.generate(winningConditionText);
		InputTextGroup inputWinningConditionTextGroup = inputWinningConditionText.splitByComma();
		BallGroup winningConditionBallGroup = BallGroup.generate(inputWinningConditionTextGroup);
		Game winningConditionGame = Game.generateCustom(winningConditionBallGroup);

		//when
		GameGroup gameGroup = new GameGroup(boughtGames);
		GameWinningCondition winningCondition = GameWinningCondition.generate(winningConditionGame);

		//then - not throw any Exception
		System.out.println(winningCondition.makeMsgWinningStatistics(gameGroup));
		assertThat(winningCondition.makeMsgWinningStatistics(gameGroup));
	}

	@DisplayName("4-1-2-5-4.`equals()` : 같은 게임 승리 조건인지 판별한다.")
	@ParameterizedTest(name = "{index} - winningCondition1:[{0}], winningCondition2:{1}, isEqual:{2}")
	@Order(5)
	@CsvSource(value = {"1,2,3,4,5,6;1,2,3,4,5,6;true", "1,2,3,4,5,6;2,3,4,5,6,7;false",
		"1,2,3,4,5,6;1,3,5,2,4,6;true"}, delimiter = ';')
	void equals(String winningCondition1, String winningCondition2, boolean isEqual) throws
			IoContextIllegalParameterException,
			GameContextIllegalParameterException {
		//given

		//when
		InputText inputText1 = InputText.generate(winningCondition1);
		InputTextGroup inputTextGroup1 = inputText1.splitByComma();
		BallGroup ballGroup1 = BallGroup.generate(inputTextGroup1);
		Game customGame1 = Game.generateCustom(ballGroup1);
		GameWinningCondition gameWinningCondition1 = GameWinningCondition.generate(customGame1);

		InputText inputText2 = InputText.generate(winningCondition2);
		Round round = Round.generate().setupGameWinningCondition(inputText2);

		//then
		assertThat(round.gameWinningCondition().isSameWinningCondition(gameWinningCondition1)).isEqualTo(isEqual);
	}
}
