package lotto.view;

import java.util.Scanner;

public class InputView {
	public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

	public int inputMoney(){
		System.out.println(INPUT_MONEY_MESSAGE);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
}
