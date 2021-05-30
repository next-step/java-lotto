package lotto.game.domain.aggregate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lotto.game.domain.vo.Ball;
import lotto.game.exception.IllegalBallGroupException;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.vo.InputText;

public class BallGroup {
	private static final List<Ball> ALL_OF_BALLS = new ArrayList<>();

	private final List<Ball> balls;

	private BallGroup(List<Ball> unmodifiableList) {
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
		Ball pendingBall = Ball.of(inputText);
		if (!destinationBalls.contains(pendingBall)) {
			destinationBalls.add(pendingBall);
		}
	}

	public static BallGroup generate(InputTextGroup inputTextGroup) {
		InputTextGroup.validateInputTextGroup(inputTextGroup);
		List<Ball> balls = new ArrayList<>();
		for (InputText inputText : inputTextGroup.inputTexts()) {
			addBallWhenNotDuplicated(balls, inputText);
		}
		Collections.sort(balls);
		return new BallGroup(Collections.unmodifiableList(balls));
	}

	public static BallGroup generate(List<Ball> subList) {
		validateGenerate(subList);
		List<Ball> balls = new ArrayList<>(subList);
		Collections.sort(balls);
		return new BallGroup(Collections.unmodifiableList(balls));
	}

	public static List<Ball> allOfBalls() {
		return new ArrayList<>(ALL_OF_BALLS);
	}

	public List<Ball> balls() {
		return Collections.unmodifiableList(this.balls);
	}

	private static void validateNotNull(Object object) {
		if (Objects.isNull(object)) {
			throw new IllegalBallGroupException("입력값이 최소 1개 이상 존재해야 합니다.");
		}
	}

	private static void validateNotEmpty(List<Ball> subList) {
		if (subList.isEmpty()) {
			throw new IllegalBallGroupException("입력값이 최소 1개 이상 존재해야 합니다.");
		}
	}

	private static void validateGenerate(List<Ball> subList) {
		validateNotNull(subList);
		validateNotEmpty(subList);
	}

	public static void validateBallGroup(BallGroup ballGroup) {
		validateNotNull(ballGroup);
		validateGenerate(ballGroup.balls);
	}

	public boolean isContainBall(Ball ball) {
		return balls.contains(ball);
	}
}
