package lotto.game.domain.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.game.domain.aggregate.BallGroup;
import lotto.game.exception.IllegalBallGroupException;
import lotto.game.exception.IllegalBallNumberException;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextException;
import lotto.io.exception.IllegalInputTextGroupException;
import lotto.io.exception.IllegalInputTextListException;

public class GameTest {

	@DisplayName("4-1-2-3-1.generateAuto() - 시도 횟수 : 100회, 경우의 수 : 2179827, 테스트 실패 확률 : 약0.00459%")
	@ParameterizedTest(name = "{index} - text:[{0}]")
	@Order(1)
	@CsvSource(value = {"1,2,3,4,5,6"}, delimiter = ';')
	void generateAuto(String compareBallGroupText) throws
			IllegalInputTextException,
			IllegalInputTextListException,
			IllegalBallNumberException,
			IllegalInputTextGroupException {
		//given
		InputTextGroup inputTextGroup = InputText.generate(compareBallGroupText).splitByComma();
		BallGroup compareBallGroup = BallGroup.generate(inputTextGroup);

		//when
		Game newGame = Game.generateAuto();

		//then
		for (int i = 0; i < 100; i++) {
			assertThat(newGame.ballGroup().balls()).doesNotContainSequence(compareBallGroup.balls());
		}
	}

	@DisplayName("4-1-2-3-2.`generateCustom()` : 모든 볼의 정보를 토대로 게임을 수동으로 생성한다.")
	@ParameterizedTest(name = "{index} - text:[{0}]")
	@Order(2)
	@CsvSource(value = {"1,2,3,4,5,6;1,2,3,4,5,6;true", "6,5,4,3,2,1;1,2,3,4,5,6;true",
			"1,2,3,3,4,5,6;1,2,3,4,5,6;true", "1, 21, 31, 45, 41, 11;1,11,21,31,41,45;true"}, delimiter = ';')
	void generateCustom(String text, String compareText, boolean expectedIsEqual) throws
			IllegalInputTextException, IllegalInputTextListException, IllegalBallNumberException,
			IllegalInputTextGroupException, IllegalBallGroupException {
		//given
		InputTextGroup inputTextGroup = InputText.generate(text).splitByComma();
		BallGroup ballGroup = BallGroup.generate(inputTextGroup);

		InputTextGroup compareInputTextGroup = InputText.generate(compareText).splitByComma();
		BallGroup compareBallGroup = BallGroup.generate(compareInputTextGroup);

		//when
		Game newGame = Game.generateCustom(ballGroup);

		//then
		assertThat(newGame.ballGroup().balls()).containsSequence(compareBallGroup.balls());
	}

	@DisplayName("4-1-2-3-2.generateCustom() - throw Exceptions")
	@ParameterizedTest(name = "{index} - text:[{0}]")
	@Order(3)
	@CsvSource(value = {"1,2,3,4,5", "1,2,3,4,4,5", "1,2,3,3,4,5,6,7"}, delimiter = ';')
	void generateCustomWithException(String text) throws
			IllegalInputTextException, IllegalInputTextListException, IllegalBallNumberException,
			IllegalInputTextGroupException, IllegalBallGroupException {
		//given
		InputTextGroup inputTextGroup = InputText.generate(text).splitByComma();
		BallGroup ballGroup = BallGroup.generate(inputTextGroup);

		//when

		//then
		assertThatThrownBy(() -> Game.generateCustom(ballGroup)).isInstanceOf(IllegalBallGroupException.class);
	}

	@DisplayName("4-1-2-3-3.equals()")
	@ParameterizedTest(name = "{index} - text:[{0}], compareText[{1}], expectedIsEqual:{2}")
	@Order(4)
	@CsvSource(value = {"1,2,3,4,5,6;1,2,3,4,5,6;true", "6,5,4,3,2,1;1,2,3,4,5,6;true",
		"1,2,3,3,4,5,6;1,8,3,4,5,6;false", "1, 21, 31, 45, 41, 11;1,11,21,31,41,45;true"}, delimiter = ';')
	void equals(String text, String compareText, boolean expectedIsEqual) throws
			IllegalInputTextException,
			IllegalInputTextListException,
			IllegalBallNumberException,
			IllegalInputTextGroupException,
			IllegalBallGroupException {
		//given
		InputTextGroup inputTextGroup = InputText.generate(text).splitByComma();
		BallGroup ballGroup = BallGroup.generate(inputTextGroup);

		InputTextGroup compareInputTextGroup = InputText.generate(compareText).splitByComma();
		BallGroup compareBallGroup = BallGroup.generate(compareInputTextGroup);

		//when
		Game newGame = Game.generateCustom(ballGroup);
		Game compareGame = Game.generateCustom(compareBallGroup);

		//then
		assertThat(newGame.isContainSameBalls(compareGame)).isEqualTo(expectedIsEqual);
	}
}
