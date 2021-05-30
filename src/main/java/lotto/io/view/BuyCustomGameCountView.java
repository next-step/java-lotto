package lotto.io.view;

import lotto.game.domain.entity.Round;
import lotto.game.domain.vo.CustomGameCount;
import lotto.io.domain.code.ProcessCode;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.entity.ViewStatus;
import lotto.io.domain.vo.InputText;

public class BuyCustomGameCountView extends View {

	private BuyCustomGameCountView() {

	}

	@Override
	public ViewCode viewCode() {
		return ViewCode.BUY_CUSTOM_GAME_COUNT;
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
			changeViewStatusWhenSystemIn(viewStatus, round);
			return;
		}
		changeViewStatusDefault(viewStatus);
	}

	public static BuyCustomGameCountView generate() {
		return new BuyCustomGameCountView();
	}

	private void changeViewStatusWhenRequestInput(ViewStatus viewStatus) {
		viewStatus.changeCurrentProcessCode(ProcessCode.SYSTEM_IN);
	}

	private void changeViewStatusWhenSystemIn(ViewStatus viewStatus, Round round) {
		if (round.isFinishBuyCustomGames()) {
			viewStatus.changeCurrentViewCode(ViewCode.TICKET_BOX);
			viewStatus.changeCurrentProcessCode(ProcessCode.FINISH);
			return;
		}
		viewStatus.changeCurrentViewCode(ViewCode.BUY_CUSTOM_GAME);
		viewStatus.changeCurrentProcessCode(ProcessCode.REQUEST_INPUT);
	}

	private void changeViewStatusDefault(ViewStatus viewStatus) {
		viewStatus.changeCurrentProcessCode(ProcessCode.REQUEST_INPUT);
	}

	public void processWhenRequestInput() {
		System.out.println(viewCode().inputRequestMessage());
	}

	private void processWhenSystemIn(Round round, InputText inputText) {
		CustomGameCount customGameCount = CustomGameCount.generate(inputText, round.money());
		round.setupCustomGameCount(customGameCount);
	}

}
