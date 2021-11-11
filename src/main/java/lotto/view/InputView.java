package lotto.view;

import java.util.Scanner;

import lotto.domain.Ticket;
import lotto.exception.UtilCreationException;

public final class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String WINNING_NUMBER_DELIMITER = ", ";

	private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String PURCHASE_COMPLETE_MESSAGE = "%d개를 구매했습니다.\n";
	private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

	private InputView() {
		throw new UtilCreationException();
	}

	public static int getNumberOfPurchases() {
		System.out.println(PURCHASE_MESSAGE);
		int purchasePrice = SCANNER.nextInt();
		SCANNER.nextLine();
		int numberOfPurchases = purchasePrice / Ticket.PRICE;
		System.out.printf(PURCHASE_COMPLETE_MESSAGE, numberOfPurchases);
		return numberOfPurchases;
	}

	public static Ticket getWinningNumberTicket() {
		System.out.println(WINNING_NUMBER_MESSAGE);
		String winningNumber = SCANNER.nextLine();
		return Ticket.createWinningNumberTicket(winningNumber.split(WINNING_NUMBER_DELIMITER));
	}
}
