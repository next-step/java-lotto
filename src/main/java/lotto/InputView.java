package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import calculator.Input;
import calculator.Tokenizer;

public class InputView {
	public static final String LOTTO_PURCHASE_INPUT = "구입금액을 입력해 주세요.";
	public static final String WINNING_NUMBER_MSG = "지난 주 당첨 번호를 입력해 주세요.";

	public static final Scanner scanner = new Scanner(System.in);

	public static void print(String msg) {
		System.out.println(msg);
	}

	public static int inputMoney() {
		System.out.println(LOTTO_PURCHASE_INPUT);
		int inputMoney = scanner.nextInt();
		scanner.nextLine();
		return inputMoney;
	}

	public static List<LottoNumber> inputWinningNumber() {
		InputView.print(InputView.WINNING_NUMBER_MSG);
		String input = scanner.next();
		String[] lottoNum = new Tokenizer(new Input(input)).split();

		return Arrays.stream(lottoNum).map(Integer::parseInt).map(LottoNumber::new).collect(Collectors.toList());
	}
}
