package ui;

import java.util.List;
import java.util.Scanner;

import lotto.LottoTicket;

public class InputView {
	public static final String QUESTION_OF_TOTAL_COST = "구입금액을 입력해 주세요.";
	public static final String QUESTION_OF_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String QUESTION_OF_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public void drawQuestionOfMoney() {
		System.out.println(QUESTION_OF_TOTAL_COST);
	}

	public int inputAmountOfMoney() {
		return this.scanner.nextInt();
	}

	public void drawQuestionOf1stLotto() {
		System.out.println(QUESTION_OF_WINNING_NUMBER);
	}

	public void drawQuestionOfBonusNumber() {
		System.out.println(QUESTION_OF_BONUS_NUMBER);
	}

	public int inputBonusNumber() {
		return this.scanner.nextInt();
	}

	public String inputLottoNumbers() {
		this.scanner.nextLine();
		return this.scanner.nextLine();
	}

	public void drawLottoNumbers(List<LottoTicket> lottoTickets) {
		lottoTickets.forEach(lottoTicket -> System.out.println(lottoTicket.lottoNumbers()));
	}
}
