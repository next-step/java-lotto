package lotto.enums;

public enum Message {

	PURCHASE("구입 금액을 입력해주세요. (1,000 ~ 1,000,000)"),
	AUTOMATIC_TICKETING("%d개를 구매했습니다."),
	WINNING_TICKET("지난 주 당첨 번호를 입력해 주세요.");

	private String message;

	Message(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}

}
