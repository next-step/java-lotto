package lotto.io.view;

import lotto.game.domain.aggregate.BallGroup;
import lotto.game.domain.entity.Round;
import lotto.game.domain.vo.Game;
import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.domain.code.ProcessCode;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.entity.ViewStatus;
import lotto.io.domain.vo.InputText;

public class BuyCustomGameView extends View {

	private BuyCustomGameView() {

	}

	@Override
	public ViewCode viewCode() {
		return ViewCode.BUY_CUSTOM_GAME_COUNT;
	}

	@Override
	public void displayProcess(ViewStatus viewStatus, Round round, InputText inputText) {
		if (viewStatus.isRequestInputProcess()) {
			processWhenRequestInput(round);
			changeViewStatusWhenRequestInput(viewStatus);
			return;
		}
		if (viewStatus.isSystemInProcess()) {
			processWhenSystemIn(round, inputText);
			changeViewStatusWhenSystemIn(viewStatus, round);
			return;
		}
		changeViewStatusDefault(viewStatus);
	}

	public static BuyCustomGameView generate() {
		return new BuyCustomGameView();
	}

	private void changeViewStatusWhenRequestInput(ViewStatus viewStatus) {
		viewStatus.changeCurrentProcessCode(ProcessCode.SYSTEM_IN);
	}

	private void changeViewStatusWhenSystemIn(ViewStatus viewStatus, Round round) {
		if (isFinishBuyCustomGames(round)) {
			viewStatus.changeCurrentViewCode(ViewCode.TICKET_BOX);
			viewStatus.changeCurrentProcessCode(ProcessCode.FINISH);
			return;
		}
		viewStatus.changeCurrentProcessCode(ProcessCode.REQUEST_INPUT);
	}

	private boolean isFinishBuyCustomGames(Round round) {
		return round.isFinishBuyCustomGames();
	}

	private void changeViewStatusDefault(ViewStatus viewStatus) {
		viewStatus.changeCurrentProcessCode(ProcessCode.REQUEST_INPUT);
	}

	public void processWhenRequestInput(Round round) {
		String message = viewCode().inputRequestMessage()
			+ String.format("(입력된 수동 번호 : %d, 입력할 전체 수동 번호 : %d)", round.boughtGamesCount(), round.customGameCount());
		System.out.println(message);
	}

	private void processWhenSystemIn(Round round, InputText inputText) {
		InputTextGroup inputTextGroup = inputText.splitByComma();
		BallGroup customBallGroup = BallGroup.generate(inputTextGroup);
		Game customGame = Game.generateCustom(customBallGroup);
		round.buyCustomGame(customGame);
	}

}
