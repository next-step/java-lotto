package lotto.view;

import java.util.Scanner;

public class InputView {
	private static Scanner sc = new Scanner(System.in);

	public int inputTotalAmount() {
		System.out.println("구매 금액을 입력해주세요");
		return sc.nextInt();
	}
}
