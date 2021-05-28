package lotto.io.domain.code;

public enum ViewCode {
	TICKET_BOX("구입금액을 입력해 주세요."),
	GAME_WINNING_CONDITION("지난 주 당첨 번호를 입력해 주세요."),
	BONUS_BALL("보너스 볼을 입력해 주세요."),
	WINNING_STATICS(""),
	SHUTDOWN_APPLICATION("");

	private final String inputRequestMessage;

	ViewCode(String inputRequestMessage) {
		this.inputRequestMessage = inputRequestMessage;
	}

	public boolean isTicketBoxView() {
		return this == TICKET_BOX;
	}

	public boolean isGameWinningConditionView() {
		return this == GAME_WINNING_CONDITION;
	}

	public boolean isBonusBall() {
		return this == BONUS_BALL;
	}

	public boolean isWinningStaticsView() {
		return this == WINNING_STATICS;
	}

	public boolean isShutdownApplication() {
		return this == SHUTDOWN_APPLICATION;
	}

	public String inputRequestMessage() {
		return inputRequestMessage;
	}

}
