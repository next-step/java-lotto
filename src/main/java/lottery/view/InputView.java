package lottery.view;

import java.util.Set;
import java.util.stream.Collectors;

import lottery.Tickets;

public class InputView {

	public void askForBuyerMoney() {
		print("구입금액을 입력해 주세요");
	}

	public void inputCountOfTickets(int count) {
		print(count + "개를 구매했습니다.");
	}

	public void printTickets(Tickets tickets) {
		tickets.getValues().forEach(ticket -> {
			Set<Integer> numbers = ticket.numbers();
			print("[" + numbers.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(", ")) + "]");
		});
	}

	public void askForLastWeekTickets() {
		print("지난 주 당첨 번호를 입력해 주세요.");
	}
	public void askForBonusNumber(){
		print("보너스 볼을 입력해 주세요.");
	}

	private void print(String x) {
		System.out.println(x);
	}
}
