package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.LottoTicket;

public class InputView {
	public static final String QUESTION_OF_TOTAL_COST = "구입금액을 입력해 주세요.";
	public static final String QUESTION_OF_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String QUESTION_OF_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	public static final String QUESTION_OF_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
	public static final String QUESTION_OF_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
	public static final String INTRO_MANUAL_FIRST = "수동으로 ";
	public static final String INTRO_MANUAL_MIDLE = "장, 자동으로 ";
	public static final String INTRO_MANUAL_END = "개를 구매했습니다.";
	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	private void drawQuestionOfMoney() {
		System.out.println(QUESTION_OF_TOTAL_COST);
	}

	private void drawQuestionOf1stLotto() {
		System.out.println(QUESTION_OF_WINNING_NUMBER);
	}

	private void drawQuestionOfBonusNumber() {
		System.out.println(QUESTION_OF_BONUS_NUMBER);
	}

	private void drawQuestionOfManualCount() {
		System.out.println(QUESTION_OF_MANUAL_COUNT);
	}

	private void drawQuestionOfManualLottoNumbers() {
		System.out.println(QUESTION_OF_MANUAL_NUMBERS);
	}

	public int inputAmountOfMoney() {
		drawQuestionOfMoney();

		return this.scanner.nextInt();
	}

	public int inputBonusNumber() {
		drawQuestionOfBonusNumber();

		return this.scanner.nextInt();
	}

	private int inputManualCount() {
		drawQuestionOfManualCount();

		int input = this.scanner.nextInt();
		this.scanner.nextLine();
		return input;
	}

	public String inputLottoNumbers() {
		return this.scanner.nextLine();
	}

	public void drawLottoNumbers(List<LottoTicket> manualLottoTickets, List<LottoTicket> lottoTickets) {
		System.out.println(INTRO_MANUAL_FIRST + manualLottoTickets.size() + INTRO_MANUAL_MIDLE + lottoTickets.size()
			+ INTRO_MANUAL_END);
		lottoTickets.forEach(lottoTicket -> System.out.println(lottoTicket.lottoNumbers()));
	}

	public List<String> inputManualLottoNumbers() {
		int count = inputManualCount();
		ArrayList<String> numbers = new ArrayList<>();

		if (count != 0) {
			drawQuestionOfManualLottoNumbers();
		}

		for (int i = 0; i < count; i++) {
			numbers.add(inputLottoNumbers());
		}
		return numbers;
	}

	public String inputWinningNumbers() {
		drawQuestionOf1stLotto();
		return this.scanner.nextLine();
	}
}
