package lotto.io.view;

import lotto.game.domain.aggregate.BallGroup;
import lotto.game.domain.aggregate.GameGroup;
import lotto.game.domain.entity.Round;
import lotto.game.domain.vo.Ball;
import lotto.game.domain.vo.Game;
import lotto.game.domain.vo.Money;
import lotto.io.domain.code.ProcessCode;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.entity.ViewStatus;
import lotto.io.domain.vo.InputText;

public class TicketBoxView extends View {

	@Override
	public ViewCode viewCode() {
		return ViewCode.TICKET_BOX;
	}

	@Override
	public void displayProcess(ViewStatus viewStatus, Round round, InputText inputText) {
		if (viewStatus.isRequestInputProcess()) {
			processWhenRequestInput();
			changeViewStatusWhenRequestInput(viewStatus);
			return;
		}
		if (viewStatus.isSystemInProcess()) {
			processWhenSystemIn(round, inputText);
			changeViewStatusWhenSystemIn(viewStatus);
			return;
		}
		if (viewStatus.isFinishProcess()) {
			processWhenFinish(round);
			changeViewStatusWhenFinish(viewStatus);
		}
	}

	public static TicketBoxView generate() {
		return new TicketBoxView();
	}

	private void changeViewStatusWhenRequestInput(ViewStatus viewStatus) {
		viewStatus.changeCurrentProcessCode(ProcessCode.SYSTEM_IN);
	}

	private void changeViewStatusWhenSystemIn(ViewStatus viewStatus) {
		viewStatus.changeCurrentProcessCode(ProcessCode.FINISH);
	}

	private void changeViewStatusWhenFinish(ViewStatus viewStatus) {
		viewStatus.changeCurrentViewCode(ViewCode.GAME_WINNING_CONDITION);
		viewStatus.changeCurrentProcessCode(ProcessCode.REQUEST_INPUT);
	}

	public void processWhenRequestInput() {
		System.out.println(viewCode().inputRequestMessage());
	}

	private void processWhenSystemIn(Round round, InputText inputText) {
		Money money = Money.generate(inputText);
		round.raiseMoney(money);
		GameGroup boughtGames = GameGroup.buyGames(round.money());
		round.setupBoughtGames(boughtGames);
	}

	private void processWhenFinish(Round round) {
		printBoughtGames(round.boughtGames());
	}

	private void printBoughtGames(GameGroup boughtGamesGroup) {
		System.out.println(boughtGamesGroup.gamesCount() + "개를 구매했습니다.");
		for (Game boughtGame : boughtGamesGroup.games()) {
			printBoughtGame(boughtGame);
		}
		System.out.println();
	}

	private void printBoughtGame(Game boughtGame) {
		printBallGroup(boughtGame.ballGroup());
	}

	private void printBallGroup(BallGroup ballGroup) {
		StringBuilder stringBuilder = new StringBuilder("[");
		for (Ball ball : ballGroup.balls()) {
			stringBuilder.append(ball.number()).append(",");
		}
		stringBuilder.replace(stringBuilder.lastIndexOf(","), stringBuilder.length(), "]");
		System.out.println(stringBuilder);
	}
}
