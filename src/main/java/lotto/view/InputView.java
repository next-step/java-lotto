package lotto.view;

import lotto.dto.InputLottoNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static int receiveAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static int receiveSelfBuyCount() {
		System.out.println();
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return scanner.nextInt();
	}

	public static List<InputLottoNumbers> receiveSelfLottoNumbers(int selfBuyCount) {
		System.out.println();
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		removeScannerBuffer();
		List<InputLottoNumbers> lottoNumbersBunch = new ArrayList<>();
		for (int i = 0; i < selfBuyCount; i++) {
			lottoNumbersBunch.add(new InputLottoNumbers(InputParser.parse(scanner.nextLine())));
		}
		return lottoNumbersBunch;
	}

	public static List<Integer> receiveAnswerNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return InputParser.parse(scanner.nextLine());
	}

	private static void removeScannerBuffer() {
		scanner.nextLine();
	}

	public static int receiveBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}

}
