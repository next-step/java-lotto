package ui;

import domain.Lotto;
import domain.LottoOrderGroup;
import domain.LottoOrderGroupAnalysis;

import java.util.Scanner;

import static domain.Lotto.*;
import static ui.IOMessage.*;

public class LottoController {
	private final Scanner scanner = new Scanner(System.in);

	public void insertMoney () {
		while (true) {
			System.out.println(ASK_INSERTMONEY);

			final Integer lottoAmount = validMoney(scanner.nextLine().trim());

			System.out.println(lottoAmount + PURCHASE_MENT_SURFIX);

			final LottoOrderGroup lottoOrderGroup = new LottoOrderGroup(lottoAmount);

			for (Lotto lotto : lottoOrderGroup.lottos()) {
				System.out.println(lotto);
			}

			System.out.println(); // 줄바꿈용
			System.out.println(ASK_LOTTO_WINNER_NUMBER);

			final Integer[] winnerNumbers = 	validWinnerNumbers(scanner.nextLine().trim());

			LottoOrderGroupAnalysis analysis = new LottoOrderGroupAnalysis(winnerNumbers, lottoOrderGroup);

			System.out.println(); // 줄바꿈용
			System.out.println(PRINT_ANALYSIS_TITLE);
			System.out.println(PRINT_LINE);
			System.out.printf(MATCH_3_NUMBERS+"%d개%n", analysis.match3());
			System.out.printf(MATCH_4_NUMBERS+"%d개%n", analysis.match4());
			System.out.printf(MATCH_5_NUMBERS+"%d개%n", analysis.match5());
			System.out.printf(MATCH_6_NUMBERS+"%d개%n", analysis.match6());

			System.out.printf("총 수익률은 %s입니다.%n", analysis.yield());
		}
	}

	private Integer validMoney(String inputMoney) {
		final int money = Integer.parseInt(inputMoney);

		if (money % 1000 > 0) {
			throw new NumberFormatException("1000원단위로 입력해주세요.");
		}

		return  money/ 1000;
	}

	private Integer[] validWinnerNumbers(String winnerNumbers) {
		String[] stringNumbers = winnerNumbers.split(",");

		if (stringNumbers.length != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException("6자리 숫자를 ,을 이용해 입력해 주세요.");
		}

		Integer[] numbers = new Integer[LOTTO_NUMBER_LENGTH];

		for (Integer i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
			numbers[i] = Integer.parseInt(stringNumbers[i]);
		}

		return numbers;
	}
}
