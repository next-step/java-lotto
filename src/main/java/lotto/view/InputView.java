package lotto.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lotto.domain.Ticket;
import lotto.exception.UtilCreationException;

public final class InputView {
	private static final String WINNING_NUMBER_DELIMITER = ", ";

	private InputView() {
		throw new UtilCreationException();
	}

	public static int getNumberOfPurchases() {
		System.out.println("구입금액을 입력해 주세요.");
		int purchasePrice = new Scanner(System.in).nextInt();
		int numberOfPurchases = purchasePrice / Ticket.PRICE;
		System.out.printf("%d개를 구매했습니다.\n", numberOfPurchases);
		return numberOfPurchases;
	}

	public static Ticket getWinningNumberTicket() {
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		String winningNumber = new Scanner(System.in).nextLine();
		List<Integer> winningNumbers = Arrays.stream(winningNumber.split(WINNING_NUMBER_DELIMITER))
			.map(Integer::parseInt)
			.sorted()
			.collect(toList());
		return Ticket.create(winningNumbers);
	}
}
