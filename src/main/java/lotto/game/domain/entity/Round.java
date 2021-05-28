package lotto.game.domain.entity;

import lotto.game.domain.aggregate.BallGroup;
import lotto.game.domain.aggregate.GameGroup;
import lotto.game.domain.vo.Ball;
import lotto.game.domain.vo.Game;
import lotto.game.domain.vo.Money;
import lotto.game.exception.IllegalBonusBallException;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.vo.InputText;

public class Round {
	private Game gameWinningCondition;
	private GameGroup boughtGames;
	private Money money;
	private Ball bonusBall;

	public static Round generate() {
		return new Round();
	}

	public Round setupGameWinningCondition(InputText inputText) {
		InputTextGroup inputTextGroup = inputText.splitByComma();
		BallGroup ballGroup = BallGroup.generate(inputTextGroup);
		this.gameWinningCondition = Game.generateCustom(ballGroup);
		return this;
	}

	public Round setupBonusBall(InputText inputText) {
		Ball bonusBall = Ball.generate(inputText);
		if (gameWinningCondition.isContainBall(bonusBall)) {
			throw new IllegalBonusBallException("당첨 번호에 포함되지 않는 번호만 보너스 볼로 지정될 수 있습니다.");
		}
		this.bonusBall = bonusBall;
		return this;
	}

	public Game gameWinningCondition() {
		return this.gameWinningCondition;
	}

	public void setupBoughtGames(GameGroup boughtGames) {
		this.boughtGames = boughtGames;
	}

	public void raiseMoney(Money money) {
		this.money = money;
	}

	public Money money() {
		return this.money;
	}

	public GameGroup boughtGames() {
		return this.boughtGames;
	}

	public Ball bonusBall() {
		return this.bonusBall;
	}

}
