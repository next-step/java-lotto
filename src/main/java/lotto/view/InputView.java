package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.WinningLottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by hspark on 06/11/2018.
 */
public class InputView {
	public static int inputLottoPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public static int inputManualLottoCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public static int inputLottoBonusNumber() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public static List<LottoTicket> inputManualLottoNumbers(int manualLottoCount) {
		List<LottoTicket> manualLottoTickets = new ArrayList<>();
		if (manualLottoCount != 0) {
			System.out.println("수동으로 구매 할 로또 번호를 입력해 주세요.");
			for (int i = 0; i < manualLottoCount; i++) {
				List<Integer> numbers = InputView.inputLottoNumbers();
				manualLottoTickets.add(LottoTicket.newInstanceByManual(numbers));
			}
		}
		return manualLottoTickets;
	}

	public static WinningLottoTicket inputWinningLottoNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		List<Integer> numbers = InputView.inputLottoNumbers();
		System.out.println("보너스 볼을 입력해 주세요.");
		int bonusNumber = InputView.inputLottoBonusNumber();
		return new WinningLottoTicket(numbers, bonusNumber);
	}

	private static List<Integer> inputLottoNumbers() {
		Scanner scanner = new Scanner(System.in);
		return Arrays.stream(scanner.nextLine().split(","))
			.map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
	}
}
