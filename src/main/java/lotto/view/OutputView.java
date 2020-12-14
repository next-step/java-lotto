package lotto.view;

public class OutputView {

	public static void printPurchaseMessage(int numberOfManualTicket, int numberOfAutoTicket) {
		System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", numberOfManualTicket, numberOfAutoTicket));
	}

	public static void printMessage(String lottoTicketMessage) {
		System.out.println(lottoTicketMessage);
	}
}
