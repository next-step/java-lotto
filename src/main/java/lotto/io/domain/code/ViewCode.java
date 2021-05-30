package lotto.io.domain.code;

import lotto.io.view.BonusBallView;
import lotto.io.view.BuyCustomGameCountView;
import lotto.io.view.BuyCustomGameView;
import lotto.io.view.GameWinningConditionView;
import lotto.io.view.TicketBoxView;
import lotto.io.view.View;
import lotto.io.view.WinningStaticsView;

public enum ViewCode {
	TICKET_BOX("구입금액을 입력해 주세요.", TicketBoxView.generate()),
	BUY_CUSTOM_GAME_COUNT("수동으로 구매할 로또 수를 입력해 주세요.", BuyCustomGameCountView.generate()),
	BUY_CUSTOM_GAME("수동으로 구매할 번호를 입력해 주세요.", BuyCustomGameView.generate()),
	GAME_WINNING_CONDITION("지난 주 당첨 번호를 입력해 주세요.", GameWinningConditionView.generate()),
	BONUS_BALL("보너스 볼을 입력해 주세요.", BonusBallView.generate()),
	WINNING_STATICS("", WinningStaticsView.generate()),
	SHUTDOWN_APPLICATION("", null);

	private final String inputRequestMessage;
	private final View view;

	ViewCode(String inputRequestMessage, View view) {
		this.inputRequestMessage = inputRequestMessage;
		this.view = view;
	}

	public boolean isShutdownApplication() {
		return this == SHUTDOWN_APPLICATION;
	}

	public String inputRequestMessage() {
		return inputRequestMessage;
	}

	public View view() {
		return this.view;
	}
}
