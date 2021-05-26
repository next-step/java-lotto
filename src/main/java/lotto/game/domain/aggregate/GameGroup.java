package lotto.game.domain.aggregate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.game.domain.vo.Game;
import lotto.game.domain.vo.Money;
import lotto.game.exception.IllegalMoneyAmountException;

public class GameGroup {
	private static final int EFFECTIVE_MIN_COUNT_OF_GAMES = 1;

	private final List<Game> games;

	public GameGroup(List<Game> newGames) {
		this.games = newGames;
	}

	public static GameGroup buyGames(Money money) {
		validateBuyGames(money);
		List<Game> newGames = makeGamesWithinMoneyRange(money);
		return new GameGroup(newGames);
	}

	private static List<Game> makeGamesWithinMoneyRange(Money money) {
		List<Game> newGames = new ArrayList<>();
		for (int i = 0; i < money.countOfGames(); i++) {
			newGames.add(Game.generateAuto());
		}
		return newGames;
	}

	private static void validateBuyGames(Money money) {
		validateCountOfGames(money);
	}

	private static void validateCountOfGames(Money money) {
		if (!isEffectiveMinCountOfGames(money.countOfGames())) {
			throw new IllegalMoneyAmountException("1개 이상의 게임을 구매할 수 있는 " + Money.GAME_FEE + "원 이상의 금액이 필요합니다.");
		}
	}

	private static boolean isEffectiveMinCountOfGames(int countOfGames) {
		return EFFECTIVE_MIN_COUNT_OF_GAMES <= countOfGames;
	}

	public List<Game> games() {
		return Collections.unmodifiableList(this.games);
	}

	public String makeMsgAllGames() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.games.size()).append("개를 구매했습니다.\n");
		this.games.forEach(game -> stringBuilder.append(game.ballGroup().makeMsgBalls()).append("\n"));
		return stringBuilder.toString();
	}
}
