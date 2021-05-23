package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

	protected static final String INPUT_LOTTO_NUMBERS_DELIMITER = ",";
	public static final String MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String MESSAGE_INPUT_WIN_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String MESSAGE_PURCHAGE_COMPLETE = "%d개를 구매했습니다.\n";

	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public int inputPurchaseAmount() {
		System.out.println(MESSAGE_INPUT_PURCHASE_AMOUNT);
		return Integer.parseInt(this.scanner.nextLine());
	}

	public List<Integer> inputWinLottoNumbers() {
		System.out.println(MESSAGE_INPUT_WIN_LOTTO_NUMBERS);
		String inputNumbers = this.scanner.nextLine();
		return toNumbers(inputNumbers, INPUT_LOTTO_NUMBERS_DELIMITER);
	}

	protected static List<Integer> toNumbers(String inputNumbers, String delimiter) {
		List<Integer> numbers = new ArrayList<>();
		List<String> strings = Arrays.asList(split(inputNumbers, delimiter));
		for (String s : strings) {
			numbers.add(Integer.parseInt(s.trim()));
		}
		return numbers;
	}

	protected static String[] split(String inputNumbers, String delimiter) {
		return inputNumbers.split(delimiter);
	}

	public static void printPurchaseLottos(List<LottoNumbers> purchaseLottos) {
		System.out.printf(MESSAGE_PURCHAGE_COMPLETE, purchaseLottos.size());

		for (LottoNumbers lotto : purchaseLottos) {
			System.out.println(lotto);
		}
		System.out.println();
	}

}
