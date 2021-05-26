package lotto.io.view;

import lotto.game.domain.entity.Round;
import lotto.game.exception.GameContextIllegalParameterException;
import lotto.io.domain.code.ProcessCode;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.entity.ViewStatus;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IoContextIllegalParameterException;

public class GameWinningConditionView extends View {

	@Override
	public ViewCode viewCode() {
		return ViewCode.GAME_WINNING_CONDITION;
	}

	@Override
	public void displayProcess(ViewStatus viewStatus, Round round, InputText inputText) throws
			GameContextIllegalParameterException,
			IoContextIllegalParameterException {
		if (viewStatus.currentProcessCode().isRequestInput()) {
			processWhenRequestInput();
			changeViewStatusWhenRequestInput(viewStatus);
			return;
		}
		if (viewStatus.currentProcessCode().isSystemIn()) {
			processWhenSystemIn(round, inputText);
			changeViewStatusWhenSystemIn(viewStatus);
			return;
		}
		changeViewStatusDefault(viewStatus);
	}

	public static View generate() {
		return new GameWinningConditionView();
	}

	private void changeViewStatusWhenRequestInput(ViewStatus viewStatus) {
		viewStatus.changeCurrentProcessCode(ProcessCode.SYSTEM_IN);
	}

	private void changeViewStatusWhenSystemIn(ViewStatus viewStatus) {
		viewStatus.changeCurrentViewCode(ViewCode.WINNING_STATICS);
		viewStatus.changeCurrentProcessCode(ProcessCode.FINISH);
	}

	private void changeViewStatusDefault(ViewStatus viewStatus) {
		viewStatus.changeCurrentProcessCode(ProcessCode.REQUEST_INPUT);
	}

	private void processWhenRequestInput() {
		System.out.println(viewCode().inputRequestMessage());
	}

	private void processWhenSystemIn(Round round, InputText inputText) throws
			GameContextIllegalParameterException,
			IoContextIllegalParameterException {
		round.setupGameWinningCondition(inputText);
	}
}
