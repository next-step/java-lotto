package lotto.game.domain.aggregate;

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

import lotto.game.domain.vo.Ball;
import lotto.game.exception.IllegalBallNumberException;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextException;
import lotto.io.exception.IllegalInputTextGroupException;
import lotto.io.exception.IllegalInputTextListException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BallGroupTest {

	private List<Ball> makeBallList(InputTextGroup inputTextGroup) throws IllegalBallNumberException {
		List<Ball> balls = new ArrayList<>();
		for (InputText inputText : inputTextGroup.inputTexts()) {
			balls.add(Ball.generate(inputText));
		}
		return balls;
	}

	@DisplayName("4-1-2-2-1.`generate()` : 입력된 정보를 토대로 BallGroup을 생성한다.")
	@ParameterizedTest(name = "{index} - text:[{0}], compareText:[{1}], exceptedIsEqual:{2}")
	@Order(1)
	@CsvSource(value = {"1, 2, 3, 4, 5, 6;1,2,3,4,5,6;true", "6,5,4,3,2,1;1,2,3,4,5,6;true",
			"45, 44, 43;43,44,45;true", "1,1,1,1,1,1;1;true", "1,2,3,1,2,3;1,2,3,1,2,3;false",
			"1,2,3,1,2,3;1,2,3;true"}, delimiter = ';')
	void generate(String text, String compareText, boolean exceptedIsEqual) throws
			IllegalInputTextException, IllegalBallNumberException,
			IllegalInputTextListException, IllegalInputTextGroupException {
		//given
		InputTextGroup inputTextGroup = InputText.generate(text).splitByComma();
		InputTextGroup inputCompareTextGroup = InputText.generate(compareText).splitByComma();
		List<Ball> compareBallList = makeBallList(inputCompareTextGroup);

		//when
		if (exceptedIsEqual) {
			//then - exceptedIsEqual:true
			assertThat(BallGroup.generate(inputTextGroup).balls()).containsSequence(compareBallList);
			return;
		}
		//then - exceptedIsEqual:false
		assertThat(BallGroup.generate(inputTextGroup).balls()).doesNotContainSequence(compareBallList);
	}

	@DisplayName("4-1-2-2-1.generate() - throw Exception")
	@ParameterizedTest(name = "{index} - text:[{0}]")
	@Order(2)
	@CsvSource(value = {"0, 1, 2, 3, 4, 5, 6", "1,,2,3", "45, 44, 43, 69", ",,,,,", "` `", "``"}, delimiter = ';')
	void generateWithThrowException(String text) {
		//given

		//when

		//then
		assertThatThrownBy(() -> {
			InputTextGroup inputTextGroup = InputText.generate(text).splitByComma();
			BallGroup.generate(inputTextGroup);
		}).isInstanceOfAny(IllegalInputTextException.class,
			IllegalInputTextListException.class, IllegalBallNumberException.class);
	}

	@DisplayName("4-1-2-2-1.generate() - throw Exception")
	@Test
	@Order(3)
	void generateWithThrowException() throws IllegalInputTextListException {
		//given
		InputTextGroup nullInputTextGroup = null;

		//when

		//then
		assertThatThrownBy(() -> BallGroup.generate(nullInputTextGroup))
			.isInstanceOf(IllegalInputTextGroupException.class);
	}

	@DisplayName("4-1-2-2-2.`allOfBalls()` : 모든 볼의 정보를 초기화하여 static 영역에 가지고 있는다.")
	@Test
	@Order(4)
	void allOfBalls() throws IllegalInputTextException, IllegalBallNumberException {
		//given
		List<Ball> compareBalls = new ArrayList<>();
		for (int i = Ball.EFFECTIVE_MIN_NUMBER; i <= Ball.EFFECTIVE_MAX_NUMBER; i++) {
			InputText inputText = InputText.generate(String.valueOf(i));
			compareBalls.add(Ball.generate(inputText));
		}

		//when

		//then
		assertThat(BallGroup.allOfBalls()).containsSequence(compareBalls);
	}

}
