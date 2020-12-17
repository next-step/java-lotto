package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLottoTicket;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static LottoTickets requireCash() {
		System.out.println("구입금액을 입력해 주세요.");
		int cash = scanner.nextInt();
		LottoTickets lottoTickets = new LottoTickets(cash);

		printTicketCount(lottoTickets.getTicketCount());
		printTickets(lottoTickets.getLottoTickets());

		return lottoTickets;
	}

	private static void printTicketCount(int ticketCount) {
		System.out.println(ticketCount + "개를 구매했습니다.");
	}

	private static void printTickets(List<LottoTicket> lottoTickets) {
		for (LottoTicket lottoTicket : lottoTickets) {
			printLottoTicketNumbers(lottoTicket);
		}
	}

	private static void printLottoTicketNumbers(LottoTicket lottoTicket) {
		List<Integer> numbers = lottoTicket.get().stream()
			.map(lottoNumber -> lottoNumber.getNumber())
			.collect(Collectors.toList());

		System.out.println(numbers.toString());
	}

	public static WinningLottoTicket requireWinningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String winningNumber = scanner.next();
		System.out.println("보너스 볼을 입력해 주세요.");
		int bonusNumber = scanner.nextInt();
		return new WinningLottoTicket(winningNumber, new LottoNumber(bonusNumber));
	}

}
