package lotto.game.domain.entity;

import java.util.List;

import lotto.game.domain.aggregate.BallGroup;
import lotto.game.domain.aggregate.GameGroup;
import lotto.game.domain.vo.Ball;
import lotto.game.domain.vo.CustomGameCount;
import lotto.game.domain.vo.Game;
import lotto.game.domain.vo.Money;
import lotto.game.exception.IllegalBonusBallException;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.vo.InputText;

public class Round {
	private final GameGroup boughtGames = GameGroup.generate();
	private Game gameWinningCondition;
	private Money money;
	private Ball bonusBall;
	private CustomGameCount customGameCount;

	private Round() {

	}

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
		Ball bonusBall = Ball.of(inputText);
		if (gameWinningCondition.isContainBall(bonusBall)) {
			throw new IllegalBonusBallException("당첨 번호에 포함되지 않는 번호만 보너스 볼로 지정될 수 있습니다.");
		}
		this.bonusBall = bonusBall;
		return this;
	}

	public Game gameWinningCondition() {
		return this.gameWinningCondition;
	}

	public void raiseMoney(Money money) {
		Money.validateRaiseMoney(money);
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

	public void setupCustomGameCount(CustomGameCount customGameCount) {
		this.customGameCount = customGameCount;
	}

	public int customGameCount() {
		return customGameCount.count();
	}

	public int boughtGamesCount() {
		return boughtGames.count();
	}

	public void buyCustomGame(Game customGame) {
		boughtGames.buyCustomGame(customGame);
	}

	public Money moneyOfAutoGames() {
		return money.amountOfAutoGames(customGameCount);
	}

	public void buyAutoGames(Money moneyOfAutoGames) {
		boughtGames.buyAutoGames(moneyOfAutoGames);
	}

	public boolean isFinishBuyCustomGames() {
		return customGameCount.count() == boughtGamesCount();
	}

	public List<Game> games() {
		return boughtGames.games();
	}
}
