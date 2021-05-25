package lotto.io.view;

import lotto.game.domain.aggregate.GameGroup;
import lotto.game.domain.entity.Round;
import lotto.game.domain.vo.Money;
import lotto.game.exception.IllegalMoneyAmountException;
import lotto.io.domain.code.ProcessCode;
import lotto.io.domain.code.ViewCode;
import lotto.io.domain.entity.ViewStatus;
import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextGroupException;

public class TicketBoxView extends View {

	@Override
	public ViewCode viewCode() {
		return ViewCode.TICKET_BOX;
	}

	@Override
	public void displayProcess(
			ViewStatus viewStatus, Round round, InputText inputText) throws
			IllegalMoneyAmountException,
			IllegalInputTextGroupException {
		if (viewStatus.currentProcessCode().isRequestInput()) {
			processWhenRequestInput();
			changeViewStatusWhenRequestInput(viewStatus);
			return;
		}
		if (viewStatus.currentProcessCode().isSystemIn()) {
			processWhenSystemIn(viewStatus, round, inputText);
			changeViewStatusWhenSystemIn(viewStatus);
			return;
		}
		if (viewStatus.currentProcessCode().isFinish()) {
			processWhenFinish(round);
			changeViewStatusWhenFinish(viewStatus);
			return;
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

	private void processWhenSystemIn(ViewStatus viewStatus, Round round, InputText inputText) throws
			IllegalMoneyAmountException,
			IllegalInputTextGroupException {
		Money money = Money.generate(inputText);
		round.raiseMoney(money);
		GameGroup boughtGames = GameGroup.buyGames(round.money());
		round.setupBoughtGames(boughtGames);
	}

	private void processWhenFinish(Round round) {
		System.out.println(round.boughtGames().makeMsgAllGames());
	}
}
