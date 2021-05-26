package lotto.game.domain.aggregate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.game.domain.vo.Ball;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextGroupException;

public class BallGroup {
	private static final List<Ball> ALL_OF_BALLS = new ArrayList<>();

	private final List<Ball> balls;

	public BallGroup(List<Ball> unmodifiableList) {
		this.balls = unmodifiableList;
	}

	static {
		makeAllOfBalls();
	}

	private static void makeAllOfBalls() {
		for (int i = Ball.EFFECTIVE_MIN_NUMBER; i <= Ball.EFFECTIVE_MAX_NUMBER; i++) {
			InputText inputText = InputText.generate(String.valueOf(i));
			addBallWhenNotDuplicated(ALL_OF_BALLS, inputText);
		}
	}

	private static void addBallWhenNotDuplicated(List<Ball> destinationBalls, InputText inputText) {
		Ball pendingBall = Ball.generate(inputText);
		if (!destinationBalls.contains(pendingBall)) {
			destinationBalls.add(pendingBall);
		}
	}

	public static BallGroup generate(InputTextGroup inputTextGroup) {
		validateGenerate(inputTextGroup);
		List<Ball> balls = new ArrayList<>();
		for (InputText inputText : inputTextGroup.inputTexts()) {
			addBallWhenNotDuplicated(balls, inputText);
		}
		Collections.sort(balls);
		return new BallGroup(Collections.unmodifiableList(balls));
	}

	private static void validateGenerate(InputTextGroup inputTextGroup) {
		validateNotNullAndNotEmpty(inputTextGroup);
	}

	private static void validateNotNullAndNotEmpty(InputTextGroup inputTextGroup) {
		if (inputTextGroup == null || inputTextGroup.inputTexts() == null || inputTextGroup.inputTexts().isEmpty()) {
			throw new IllegalInputTextGroupException("입력값이 최소 1개 이상 존재해야 합니다.");
		}
	}

	public static List<Ball> allOfBalls() {
		return new ArrayList<>(ALL_OF_BALLS);
	}

	public static BallGroup generate(List<Ball> subList) {
		validateGenerate(subList);
		List<Ball> balls = new ArrayList<>(subList);
		Collections.sort(balls);
		return new BallGroup(Collections.unmodifiableList(balls));
	}

	private static void validateGenerate(List<Ball> subList) {
		validateNotNullAndNotEmpty(subList);
	}

	private static void validateNotNullAndNotEmpty(List<Ball> subList) {
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
