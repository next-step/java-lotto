package lotto.view;

import java.util.Scanner;

import lotto.domain.LottoNumber;
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
		return lottoTickets;
	}

	public static WinningLottoTicket requireWinningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String winningNumber = scanner.next();
		System.out.println("보너스 볼을 입력해 주세요.");
		int bonusNumber = scanner.nextInt();
		return new WinningLottoTicket(winningNumber, new LottoNumber(bonusNumber));
	}

}
