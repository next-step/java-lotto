package lottery.view;

import java.util.Set;
import java.util.stream.Collectors;

import lottery.LottoNumber;
import lottery.Tickets;

public class InputView {

	public void askForBuyerMoney() {
		print("구입금액을 입력해 주세요");
	}

	public void inputCountOfTickets(int countOfManualTicket, int countOfAutomaticTicket) {
		print("수동으로 " + countOfManualTicket + "장, 자동으로" + countOfAutomaticTicket + "개를 구매했습니다.");
	}

	public void printTickets(Tickets tickets) {
		tickets.getValues().forEach(ticket -> {
			Set<LottoNumber> numbers = ticket.numbers();
			print("[" + numbers.stream()
				.map(lottoNo -> String.valueOf(lottoNo.value()))
				.collect(Collectors.joining(", ")) + "]");
		});
	}

	public void askForLastWeekTickets() {
		print("지난 주 당첨 번호를 입력해 주세요.");
	}

	public void askForBonusNumber() {
		print("보너스 볼을 입력해 주세요.");
	}

	public void askForManualTicketCount() {
		print("수동으로 구매할 로또 수를 입력해 주세요.");
	}

	public void askForManualTicketNumbers() {
		print("수동으로 구매할 번호를 입력해 주세요.");
	}

	private void print(String x) {
		System.out.println(x);
	}
}
