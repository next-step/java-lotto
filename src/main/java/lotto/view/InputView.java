package lotto.view;

import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoTicket;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {
	}

	public static int inputPrice() {
		System.out.println("구입금액을 입력해 주세요.");
		return SCANNER.nextInt();
	}

	public static void showLottoTickets(List<LottoTicket> lottoTickets) {
		System.out.printf("%s개를 구매했습니다.%n", lottoTickets.size());
		lottoTickets.forEach(lottoTicket -> System.out.println(lottoTicket.getNumbers()));
	}

}
