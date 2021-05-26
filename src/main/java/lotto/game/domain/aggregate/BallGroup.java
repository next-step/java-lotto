package lotto.game.domain.aggregate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.game.domain.vo.Ball;
import lotto.game.exception.IllegalBallNumberException;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextException;
import lotto.io.exception.IllegalInputTextGroupException;

public class BallGroup {
	private static final List<Ball> ALL_OF_BALLS = new ArrayList<>();

	private final List<Ball> balls;

	public BallGroup(List<Ball> unmodifiableList) {
		this.balls = unmodifiableList;
	}

	static {
		try {
			makeAllOfBalls();
		} catch (IllegalInputTextException | IllegalBallNumberException e) {
			e.printStackTrace();
		}
	}

	private static List<Ball> makeAllOfBalls() throws IllegalInputTextException, IllegalBallNumberException {
		List<Ball> allOfBalls = new ArrayList<>();
		for (int i = Ball.EFFECTIVE_MIN_NUMBER; i <= Ball.EFFECTIVE_MAX_NUMBER; i++) {
			InputText inputText = InputText.generate(String.valueOf(i));
			addBallWhenNotDuplicated(ALL_OF_BALLS, inputText);
		}
		return allOfBalls;
	}

	private static void addBallWhenNotDuplicated(List<Ball> destinationBalls, InputText inputText)
		throws IllegalBallNumberException {
		Ball pendingBall = Ball.generate(inputText);
		if (!destinationBalls.contains(pendingBall)) {
			destinationBalls.add(pendingBall);
		}
	}

	public static BallGroup generate(InputTextGroup inputTextGroup) throws
			IllegalBallNumberException, IllegalInputTextGroupException {
		validateGenerate(inputTextGroup);
		List<Ball> balls = new ArrayList<>();
		for (InputText inputText : inputTextGroup.inputTexts()) {
			addBallWhenNotDuplicated(balls, inputText);
		}
		Collections.sort(balls);
		return new BallGroup(Collections.unmodifiableList(balls));
	}

	private static void validateGenerate(InputTextGroup inputTextGroup) throws IllegalInputTextGroupException {
		validateNotNullAndNotEmpty(inputTextGroup);
	}

	private static void validateNotNullAndNotEmpty(InputTextGroup inputTextGroup) throws
			IllegalInputTextGroupException {
		if (inputTextGroup == null || inputTextGroup.inputTexts() == null || inputTextGroup.inputTexts().isEmpty()) {
			throw new IllegalInputTextGroupException("입력값이 최소 1개 이상 존재해야 합니다.");
		}
	}

	public static List<Ball> allOfBalls() {
		List<Ball> copiedAllOfBalls = new ArrayList<>();
		copiedAllOfBalls.addAll(ALL_OF_BALLS);
		return copiedAllOfBalls;
	}

	public static BallGroup generate(List<Ball> subList) throws IllegalInputTextGroupException {
		validateGenerate(subList);
		List<Ball> balls = new ArrayList<>();
		balls.addAll(subList);
		Collections.sort(balls);
		return new BallGroup(Collections.unmodifiableList(balls));
	}

	private static void validateGenerate(List<Ball> subList) throws IllegalInputTextGroupException {
		validateNotNullAndNotEmpty(subList);
	}

	private static void validateNotNullAndNotEmpty(List<Ball> subList) throws IllegalInputTextGroupException {
		if (subList == null || subList.isEmpty()) {
			throw new IllegalInputTextGroupException("입력값이 최소 1개 이상 존재해야 합니다.");
		}
	}

	public List<Ball> balls() {
		return Collections.unmodifiableList(this.balls);
	}

	public String makeMsgBalls() {
		StringBuilder stringBuilder = new StringBuilder("[");
		for (Ball ball : balls) {
			stringBuilder.append(ball.number()).append(",");
		}
		stringBuilder.replace(stringBuilder.lastIndexOf(","), stringBuilder.length(), "]");
		return stringBuilder.toString();
	}
}
