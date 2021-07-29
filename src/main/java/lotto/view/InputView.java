package lotto.view;

import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {
	}

	public static int inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return SCANNER.nextInt();
	}

	public static void showLottoTickets(LottoTickets lottoTickets) {
		List<LottoTicket> tickets = lottoTickets.getLottoTickets();
		System.out.printf("%s개를 구매했습니다.%n", tickets.size());
		tickets.forEach(lottoTicket -> System.out.println(lottoTicket.getNumbers()));
	}

	public static String inputWinningNumbers() {
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		return SCANNER.next();
	}

}
