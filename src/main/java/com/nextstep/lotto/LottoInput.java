package com.nextstep.lotto;

import java.util.Scanner;

public class LottoInput {

	String BUY_LOTTO_MESSAGE = "구입금액을 입력해주세요.";
	String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

	public int inputMoney() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(BUY_LOTTO_MESSAGE);

		int money = scanner.nextInt();
		return money;
	}

	public String inputWinningNumber() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(INPUT_WINNING_NUMBER);

		String winningNumbers = scanner.nextLine();
		return winningNumbers;
	}

}
