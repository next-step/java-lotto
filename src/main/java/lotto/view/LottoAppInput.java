package lotto.view;

import java.util.Scanner;

import lotto.model.Money;

public class LottoAppInput {

	private final Scanner scanner;

	public LottoAppInput(Scanner scanner) {
		this.scanner = scanner;
	}

	public Money inputMoney() {
		int input = scanner.nextInt();
		return Money.of(input);
	}
}
