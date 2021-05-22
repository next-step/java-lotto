package lotto.view;

import java.util.Scanner;

public class LottoInputView {

	private static final String INPUT_PURCHASE_LOTTO_PRICE_MESSAGE = "구입금액을 입력해 주세요";
	private static final String INPUT_LAST_WEEK_WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

	private static Scanner input = new Scanner(System.in);

	public int inputPurchaseLottoPrice() {
		System.out.println(INPUT_PURCHASE_LOTTO_PRICE_MESSAGE);
		return this.input.nextInt();
	}

	public String inputWinningLotto() {
		System.out.println(INPUT_LAST_WEEK_WINNING_LOTTO_NUMBER_MESSAGE);
		this.input = new Scanner(System.in);
		return this.input.nextLine();
	}

}
