package lotto.view;

public class OutputView {

	public static void printPurchaseMessage(int purchaseAmount) {
		System.out.println(String.format("%d개를 구매했습니다.", purchaseAmount));
	}

	public static void printMessage(String lottoTicketMessage) {
		System.out.println(lottoTicketMessage);
	}
}
