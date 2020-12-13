package lotto.domain;

import lotto.view.InputView;

import java.util.Scanner;

public class Lotto {

	InputView inputView = new InputView();

	private Scanner scanner = new Scanner(System.in);

	private int purchaseAmount;

	private static final int LOTTO_PRICE_PER_SHEET = 1000;

	public void start() {
		printInputUI();

	}

	private void printInputUI() {
		inputView.print("구입금액을 입력해 주세요.");
		this.purchaseAmount = scanner.nextInt();
		int lottoCount = calculateLottoCount(this.purchaseAmount, LOTTO_PRICE_PER_SHEET);
		inputView.print(String.format("%d개를 구매했습니다.", lottoCount));
	}

	public int calculateLottoCount(int purchaseAmount, int lottoPricePerSheet) {
		return purchaseAmount / lottoPricePerSheet;
	}
}
