package lotto.game.domain.entity;

import lotto.game.domain.aggregate.BallGroup;
import lotto.game.domain.aggregate.GameGroup;
import lotto.game.domain.vo.Game;
import lotto.game.domain.vo.GameWinningCondition;
import lotto.game.domain.vo.Money;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.vo.InputText;

public class Round {
	private GameWinningCondition gameWinningCondition;
	private GameGroup boughtGames;
	private Money money;

	public static Round generate() {
		return new Round();
	}

	public Round setupGameWinningCondition(InputText inputText) {
		InputTextGroup inputTextGroup = inputText.splitByComma();
		BallGroup ballGroup = BallGroup.generate(inputTextGroup);
		Game customGame = Game.generateCustom(ballGroup);
		this.gameWinningCondition = GameWinningCondition.generate(customGame);
		return this;
	}

	public GameWinningCondition gameWinningCondition() {
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
}
