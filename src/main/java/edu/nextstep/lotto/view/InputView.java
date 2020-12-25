package edu.nextstep.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import edu.nextstep.lotto.LottoController;

public class InputView {
	public static Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	public static int inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String input = scanner.nextLine();
		if (!Pattern.matches("^[0-9]+$", input)) {
			return inputMoney();
		}
		return Integer.parseInt(input);
	}

	public static List<Integer> inputWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return inputLottoNumbers();
	}

	public static List<Integer> inputLottoNumbers() {
		String input = scanner.nextLine();
		if (!Pattern.matches("\\s*\\d+\\s*(,\\s*\\d+\\s*)*", input)) {
			System.err.println("올바른 로또 번호가 아닙니다. 다시 입력해주세요.");
			return inputLottoNumbers();
		}
		return Arrays.stream(input.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	public static int inputBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		String input = scanner.nextLine();
		if (!Pattern.matches("^[0-9]+$", input)) {
			return inputBonusNumber();
		}
		return Integer.parseInt(input);
	}

	public static int inputManualPurchaseNumber() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		String input = scanner.nextLine();
		if (!Pattern.matches("^[0-9]+$", input)) {
			return inputManualPurchaseNumber();
		}
		return Integer.parseInt(input);
	}

	public static List<List<Integer>> inputManualNumbersList(int numberOfManualPurchase) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		List<List<Integer>> lottoNumbersList = new ArrayList<>();
		for (int i = 0; i < numberOfManualPurchase; i++) {
			lottoNumbersList.add(inputManualNumbers());
		}
		return lottoNumbersList;
	}

	private static List<Integer> inputManualNumbers() {
		List<Integer> lottoNumbers;
		while (LottoController.isNotValidLottoNumbers(lottoNumbers = InputView.inputLottoNumbers())) {
			System.err.println("올바른 로또 번호가 아닙니다. 다시 입력해주세요.");
		}
		return lottoNumbers;
	}
}