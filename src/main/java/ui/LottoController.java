package ui;

import domain.Lotto;
import domain.LottoOrderGroup;
import domain.LottoOrderGroupStatics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static domain.Lotto.LOTTO_NUMBER_LENGTH;
import static ui.IOMessage.*;
import static util.LottoPrice.LOTTO_PRICE;

public class LottoController {
	private final Scanner scanner = new Scanner(System.in);

	public void insertMoney () {
		while (true) {
			System.out.println(ASK_INSERTMONEY);

			final Integer lottoAmount = validMoney(scanner.nextLine().trim());

			System.out.println(lottoAmount + PURCHASE_MENT_SURFIX);

			final LottoOrderGroup lottoOrderGroup = new LottoOrderGroup(lottoAmount);

			printOrderGroup(lottoOrderGroup);

			System.out.println(); // 줄바꿈용
			System.out.println(ASK_LOTTO_WINNER_NUMBER);

			final List<Integer> winnerNumbers = validWinnerNumbers(scanner.nextLine().trim());

			System.out.println(ASK_LOTTO_BONUS_BALL);
			final int bonusNumber = validBonusBall(scanner.nextLine().trim());

			LottoOrderGroupStatics analysis = new LottoOrderGroupStatics(winnerNumbers, bonusNumber, lottoOrderGroup.lottos());
			analysis.matchSetting();

			printAnalysis(analysis);
		}
	}

	private int validBonusBall (String trim) {
		return Integer.parseInt(trim);
	}

	private void printOrderGroup (LottoOrderGroup group) {
		for (Lotto lotto : group.lottos()) {
			System.out.println(lotto);
		}
	}

	private void printAnalysis (LottoOrderGroupStatics analysis) {
		System.out.println(); // 줄바꿈용
		System.out.println(PRINT_ANALYSIS_TITLE);
		System.out.println(PRINT_LINE);
		System.out.printf(MATCH_3_NUMBERS + "%d개%n", analysis.match3());
		System.out.printf(MATCH_4_NUMBERS + "%d개%n", analysis.match4());
		System.out.printf(MATCH_5_NUMBERS_N_BONUS + "%d개%n", analysis.match5_bonus());
		System.out.printf(MATCH_5_NUMBERS + "%d개%n", analysis.match5());
		System.out.printf(MATCH_6_NUMBERS + "%d개%n", analysis.match6());

		System.out.printf("총 수익률은 %s입니다.%n", analysis.yield());
	}

	private Integer validMoney (String inputMoney) {
		final int money = Integer.parseInt(inputMoney);

		if (money % LOTTO_PRICE > 0) {
			throw new NumberFormatException(LOTTO_PRICE + "원단위로 입력해주세요.");
		}

		return money / LOTTO_PRICE;
	}

	private List<Integer> validWinnerNumbers (String winnerNumbers) {
		String[] stringNumbers = winnerNumbers.split(",");

		if (stringNumbers.length != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException("6자리 숫자를 ,을 이용해 입력해 주세요.");
		}

		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
			numbers.add(Integer.parseInt(stringNumbers[i]));
		}

		return numbers;
	}
}
