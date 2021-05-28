package lotto.game.domain.vo;

import java.util.Collections;
import java.util.List;

import lotto.game.domain.aggregate.BallGroup;
import lotto.game.exception.IllegalGameException;

public class Game {
	private static final int GAME_BALL_START_INDEX = 0;
	private static final int GAME_BALL_END_INDEX = 6;
	private static final int GAME_BALL_SIZE = 6;

	private final BallGroup ballGroup;

	public Game(BallGroup ballGroup) {
		this.ballGroup = ballGroup;
	}

	public static Game generateAuto() {
		List<Ball> allOfBalls = BallGroup.allOfBalls();
		Collections.shuffle(allOfBalls);
		BallGroup newBallGroup = BallGroup.generate(allOfBalls.subList(GAME_BALL_START_INDEX, GAME_BALL_END_INDEX));
		return new Game(newBallGroup);
	}

	public static Game generateCustom(BallGroup ballGroup) {
		validateGenerate(ballGroup);
		return new Game(ballGroup);
	}

	private static void validateGenerate(BallGroup ballGroup) {
		BallGroup.validateBallGroup(ballGroup);
		validateBallGroupSizeEqualSix(ballGroup);
	}

	private static void validateBallGroupSizeEqualSix(BallGroup ballGroup) {
		if (!isBallGroupSizeEqualSix(ballGroup)) {
			throw new IllegalGameException("게임은 반드시 숫자가 다른 " + GAME_BALL_SIZE + "개의 볼을 가지고 있어야 합니다.");
		}
	}

	private static boolean isBallGroupSizeEqualSix(BallGroup ballGroup) {
		return ballGroup.balls().size() == GAME_BALL_SIZE;
	}

	public BallGroup ballGroup() {
		return this.ballGroup;
	}

	public boolean isContainSameBalls(Game compareGame) {
		List<Ball> thisBalls = this.ballGroup.balls();
		List<Ball> thatBalls = compareGame.ballGroup.balls();
		return thisBalls.containsAll(thatBalls) && thatBalls.containsAll(thisBalls);
	}

	public int calculateContainWinningBalls(Game winningCondition) {
		List<Ball> boughtBalls = this.ballGroup.balls();
		return (int) winningCondition.ballGroup().balls().stream()
			.filter(boughtBalls::contains)
			.count();
	}

	public boolean isContainBall(Ball ball) {
		return ballGroup.isContainBall(ball);
	}
}
