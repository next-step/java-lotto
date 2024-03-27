package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String DELIMITER = ", ";

	public static int inputLottoMoney() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("구입금액을 입력해 주세요");
		return scanner.nextInt();
	}

	public static List<Integer> inputWinningNumber() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String inputString = scanner.nextLine();

		String[] splitInputString = getStrings(inputString);

		return getInputStringToInteger(splitInputString);
	}

	public static int inputBonusNumber() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("보너스볼을 입력해 주세요");
		return scanner.nextInt();
	}

	public static int inputManualLottoNumberCount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
		return scanner.nextInt();
	}

	public static List<List<Integer>> inputManualLottoNumber(int manualLottoNumberCount) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");

		List<List<Integer>> manualLottoNumbers = new ArrayList<>();

		for (int i = 0; i < manualLottoNumberCount; i++) {
			String inputString = scanner.nextLine();
			String[] splitInputString = getStrings(inputString);
			manualLottoNumbers.add(getInputStringToInteger(splitInputString));
		}
		return manualLottoNumbers;
	}

	private static List<Integer> getInputStringToInteger(String[] splitInputString) {
		return Arrays.stream(splitInputString)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private static String[] getStrings(String inputString) {
		String[] splitInputString = inputString.split(DELIMITER);
		return splitInputString;
	}

}
