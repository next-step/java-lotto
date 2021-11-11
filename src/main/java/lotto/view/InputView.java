package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import lotto.domain.Ticket;
import lotto.exception.UtilCreationException;

public final class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	private static final Pattern WINNING_NUMBER_PATTERN = Pattern.compile("^(\\d+, ){5}\\d+$");
	private static final String WINNING_NUMBER_DELIMITER = ", ";

	private static final String INTEGER_INPUT_MISMATCH_MESSAGE = "숫자만 입력 가능합니다.\n";
	private static final String WINNING_NUMBER_PATTERN_MISMATCH_MESSAGE = "당첨 번호 입력 형식이 올바르지 않습니다.\n";

	private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String PURCHASE_COMPLETE_MESSAGE = "%d개를 구매했습니다.\n";
	private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.\n";

	private InputView() {
		throw new UtilCreationException();
	}

	public static int getNumberOfPurchases() {
		try {
			return innerNumberOfPurchases();
		} catch (InputMismatchException e) {
			System.err.println(INTEGER_INPUT_MISMATCH_MESSAGE);
			clearScannerBuffer();
			return getNumberOfPurchases();
		}
	}

	private static int innerNumberOfPurchases() {
		System.out.println(PURCHASE_MESSAGE);
		int purchasePrice = SCANNER.nextInt();

		clearScannerBuffer();

		int numberOfPurchases = purchasePrice / Ticket.PRICE;
		System.out.printf(PURCHASE_COMPLETE_MESSAGE, numberOfPurchases);

		return numberOfPurchases;
	}

	private static void clearScannerBuffer() {
		SCANNER.nextLine();
	}

	public static Ticket getWinningNumberTicket() {
		try {
			return innerWinningNumberTicket();
		} catch (IllegalArgumentException e) {
			System.err.println(WINNING_NUMBER_PATTERN_MISMATCH_MESSAGE);
			return getWinningNumberTicket();
		}
	}

	private static Ticket innerWinningNumberTicket() {
		System.out.println(WINNING_NUMBER_MESSAGE);
		String winningNumber = SCANNER.nextLine();

		validate(winningNumber);

		return Ticket.createWinningNumberTicket(winningNumber.split(WINNING_NUMBER_DELIMITER));
	}

	private static void validate(String winningNumber) {
		if (!WINNING_NUMBER_PATTERN.matcher(winningNumber).matches()) {
			throw new IllegalArgumentException(WINNING_NUMBER_PATTERN_MISMATCH_MESSAGE);
		}
	}
}
