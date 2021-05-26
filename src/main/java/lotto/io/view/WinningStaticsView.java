package lotto.io.view;

import lotto.game.domain.aggregate.GameGroup;
import lotto.game.domain.entity.Round;
import lotto.io.domain.code.ProcessCode;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.entity.ViewStatus;
import lotto.io.domain.vo.InputText;

public class WinningStaticsView extends View {

	@Override
	public ViewCode viewCode() {
		return ViewCode.WINNING_STATICS;
	}

	@Override
	public void displayProcess(ViewStatus viewStatus, Round round, InputText inputText) {
		if (viewStatus.isFinishProcess()) {
			processWhenFinish(round);
			changeViewStatusWhenFinish(viewStatus);
		}
		changeViewStatusDefault(viewStatus);
	}

	public static View generate() {
		return new WinningStaticsView();
	}

	private void changeViewStatusDefault(ViewStatus viewStatus) {
		viewStatus.changeCurrentProcessCode(ProcessCode.FINISH);
	}

	private void changeViewStatusWhenFinish(ViewStatus viewStatus) {
		viewStatus.changeCurrentViewCode(ViewCode.SHUTDOWN_APPLICATION);
	}

	private void processWhenFinish(Round round) {
		GameGroup gameGroup = round.boughtGames();
		String messageWinningStatistics = round.gameWinningCondition().makeMsgWinningStatistics(gameGroup);
		System.out.println("\n" + messageWinningStatistics);
	}
}
