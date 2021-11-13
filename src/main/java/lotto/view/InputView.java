package lotto.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import lotto.domain.Ticket;
import lotto.domain.WinningTicket;
import lotto.exception.UtilCreationException;

public final class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	private static final Pattern WINNING_NUMBER_PATTERN = Pattern.compile("^(\\d+, ){5}\\d+$");
	private static final String LOTTO_NUMBER_DELIMITER = ", ";

	private static final String INTEGER_INPUT_MISMATCH_MESSAGE = "숫자만 입력 가능합니다.";
	private static final String WINNING_NUMBER_PATTERN_MISMATCH_MESSAGE = "당첨 번호 입력 형식이 올바르지 않습니다.";

	private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
	private static final String SIZE_OF_MANUAL_TICKET_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String NUMBER_OF_MANUAL_TICKET_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

	private InputView() {
		throw new UtilCreationException();
	}

	public static int geAvailableTicketSize() {
		try {
			return innerAvailableTicketSize();
		} catch (InputMismatchException e) {
			System.err.println(INTEGER_INPUT_MISMATCH_MESSAGE + "\n");
			clearScannerBuffer();
			return geAvailableTicketSize();
		}
	}

	private static int innerAvailableTicketSize() {
		System.out.println(PURCHASE_MESSAGE);
		int purchasePrice = SCANNER.nextInt();

		clearScannerBuffer();

		return purchasePrice / Ticket.PRICE;
	}

	private static void clearScannerBuffer() {
		SCANNER.nextLine();
	}

	public static WinningTicket getWinningTicket() {
		try {
			return innerWinningTicket();
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage() + "\n");
			return getWinningTicket();
		}
	}

	private static WinningTicket innerWinningTicket() {
		System.out.println(WINNING_NUMBER_MESSAGE);
		String winningNumber = SCANNER.nextLine();

		validate(winningNumber);

		System.out.println(BONUS_BALL_MESSAGE);
		int bonus = SCANNER.nextInt();

		clearScannerBuffer();

		return WinningTicket.create(winningNumber.split(LOTTO_NUMBER_DELIMITER), bonus);
	}

	private static void validate(String winningNumber) {
		if (!WINNING_NUMBER_PATTERN.matcher(winningNumber).matches()) {
			throw new IllegalArgumentException(WINNING_NUMBER_PATTERN_MISMATCH_MESSAGE);
		}
	}

	public static List<Ticket> getManualTickets() {
		try {
			return innerManualTickets();
		} catch (IllegalArgumentException e) {
			return getManualTickets();
		}
	}

	private static List<Ticket> innerManualTickets() {
		System.out.println(SIZE_OF_MANUAL_TICKET_MESSAGE);
		int manualCount = SCANNER.nextInt();

		clearScannerBuffer();

		System.out.println(NUMBER_OF_MANUAL_TICKET_MESSAGE);
		List<Ticket> manualTicket = new ArrayList<>(manualCount);
		for (int i = 0; i < manualCount; i++) {
			String manualNumber = SCANNER.nextLine();
			validate(manualNumber);
			manualTicket.add(Ticket.create(manualNumber.split(LOTTO_NUMBER_DELIMITER)));
		}
		return manualTicket;
	}
}
