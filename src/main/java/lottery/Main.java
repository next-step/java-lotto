package lottery;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import lottery.view.InputView;
import lottery.view.ResultView;

public class Main {

	private static final InputView inputView = new InputView();
	private static final ResultView resultView = new ResultView();
	private static final Scanner sc = new Scanner(System.in);
	private static final Store store = new Store();
	private static final InfoCenter infoCenter = new InfoCenter();

	public static void main(String[] args) {
		inputView.askForBuyerMoney();
		Money initialMoney = Money.won(getLongValue());
		Buyer buyer = Buyer.of(initialMoney);

		inputView.askForManualTicketCount();
		int manualTicketQuantity = getIntegerValue();

		inputView.askForManualTicketNumbers();
		Tickets manualTickets = getManualTickets(manualTicketQuantity);
		buyer.buyTicket(store, manualTickets);

		Tickets tickets = buyer.tickets();
		inputView.inputCountOfTickets(tickets.sizeOfManualTickets(), tickets.sizeOfAutoTickets());
		inputView.printTickets(tickets);

		inputView.askForLastWeekTickets();
		Ticket lastWeekTicket = Ticket.of(LottoNumbers.from(sc.nextLine().split(",")), TicketType.WINNING);

		inputView.askForBonusNumber();
		int bonus = Integer.parseInt(sc.nextLine().trim());
		infoCenter.setLastWeekWinningTicket(new WinningTicket(lastWeekTicket, LottoNumber.of(bonus)));

		Result result = buyer.checkTicket(infoCenter);

		float totalYield = result.getTotalYield(initialMoney);
		resultView.printResult(result, totalYield);
	}

	private static Tickets getManualTickets(int manualTicketQuantity) {
		List<Ticket> tickets = new ArrayList<>();
		for (int i = 0; i < manualTicketQuantity; i++) {
			String s = sc.nextLine();
			tickets.add(Ticket.of(LottoNumbers.from(s.split(",")), TicketType.MANUAL));
		}
		return Tickets.of(tickets);
	}

	private static long getLongValue() {
		try {
			return sc.nextLong();
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException("정수를 입력해주세요.", e);
		}
	}

	private static int getIntegerValue() {
		try {
			return sc.nextInt();
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException("정수를 입력해주세요.", e);
		} finally {
			sc.nextLine();
		}
	}

	private static String getStringValue() {
		try {
			return sc.nextLine();
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("6자리에 콤마(,)로 구분된 숫자를 입력해주세요", e);
		} finally {
			sc.nextLine();
		}
	}
}
