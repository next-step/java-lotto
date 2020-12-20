package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoNumber;
import lotto.domain.WinningLottoTicket;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
/*
	public static LottoTickets requireCash() {
		System.out.println("구입금액을 입력해 주세요.");
		int cash = scanner.nextInt();
		LottoTickets lottoTickets = new LottoTickets(cash);
		return lottoTickets;
	}*/

	private static int requireCash() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static WinningLottoTicket requireWinningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String winningNumber = scanner.next();
		System.out.println("보너스 볼을 입력해 주세요.");
		int bonusNumber = scanner.nextInt();
		return new WinningLottoTicket(winningNumber, new LottoNumber(bonusNumber));
	}

	public static BuyInfo requireBuyInfo() {
		int cash = requireCash();
		List<String> manualNumbers = requireManualNumbers(cash);
		return new BuyInfo(cash, manualNumbers);
	}

	private static List<String> requireManualNumbers(int cash) {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		int manualLottoCount = scanner.nextInt();
		BuyInfo.validateManualLottoCount(cash, manualLottoCount);

		List<String> manualNumbers = new ArrayList<>();
		if (hasRequireManualNumbers(manualLottoCount))
			return manualNumbers;

		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		manualNumbers.addAll(requireManualNumber(manualLottoCount));
		return manualNumbers;
	}

	private static List<String> requireManualNumber(int manualLottoCount) {
		List<String> manualNumbers = new ArrayList<>();
		for (int i = 0; i < manualLottoCount; i++) {
			manualNumbers.add(scanner.next());
		}
		return manualNumbers;
	}

	private static boolean hasRequireManualNumbers(int manualLottoCount) {
		return manualLottoCount < 1;
	}
}
