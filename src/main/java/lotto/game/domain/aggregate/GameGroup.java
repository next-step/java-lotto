package lotto.game.domain.aggregate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.game.domain.vo.Game;
import lotto.game.domain.vo.Money;

public class GameGroup {
	private final List<Game> games;

	private GameGroup(List<Game> newGames) {
		this.games = newGames;
	}

	public static GameGroup buyGames(Money money) {
		Money.validateMoneyForGame(money);
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

	public List<Game> games() {
		return Collections.unmodifiableList(this.games);
	}

	public int gamesCount() {
		return games.size();
	}
}
