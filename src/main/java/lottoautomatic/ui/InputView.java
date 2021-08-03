package lottoautomatic.ui;

import java.util.Scanner;

public class InputView {

	private static final String HOW_MUCH = "구입금액을 입력해 주세요.";
	private static final String LAST_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	private static final Scanner scanner = new Scanner(System.in);

	private final int money;
	private String winningNumbers;


	public InputView() {
		System.out.println(HOW_MUCH);
		this.money = Integer.parseInt(scanner.nextLine());
	}

	public int getMoney() {
		return money;
	}

	public void inputLastWinningNumbers() {
		System.out.println(LAST_WINNING_NUMBERS);
		winningNumbers = scanner.nextLine();
	}

	public String getWinningNumbers() {
		return winningNumbers;
	}

}
