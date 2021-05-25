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
			System.out.println(ASK_INSERTMONEY.getMessage());

			final Integer lottoAmount = validMoney(scanner.nextLine().trim());

			System.out.println(lottoAmount + PURCHASE_MENT_SURFIX.getMessage());

			final LottoOrderGroup lottoOrderGroup = new LottoOrderGroup(lottoAmount);

			for (Lotto lotto : lottoOrderGroup.lottos()) {
				System.out.println(lotto);
			}

			System.out.println(); // 줄바꿈용
			System.out.println(ASK_LOTTO_WINNER_NUMBER.getMessage());

			final Integer[] winnerNumbers = 	validWinnerNumbers(scanner.nextLine().trim());

			LottoOrderGroupAnalysis analysis = new LottoOrderGroupAnalysis(winnerNumbers, lottoOrderGroup);

			System.out.println(); // 줄바꿈용
			System.out.println(PRINT_ANALYSIS_TITLE);
			System.out.println(PRINT_LINE);
			System.out.printf(MATCH_3_NUMBERS.getMessage()+"%d개", analysis.match3());
			System.out.printf(MATCH_4_NUMBERS.getMessage()+"%d개", analysis.match4());
			System.out.printf(MATCH_5_NUMBERS.getMessage()+"%d개", analysis.match5());
			System.out.printf(MATCH_6_NUMBERS.getMessage()+"%d개", analysis.match6());

			System.out.printf("총 수익률은 %d입니다.", analysis.yield());
		}
	}

	private Integer validMoney(String inputMoney) {
		//TODO 1000원단위
		return Integer.parseInt(inputMoney) / 1000;
	}

	private Integer[] validWinnerNumbers(String winnerNumbers) {
		//TODO input validation
		String[] stringNumbers = winnerNumbers.split(",");
		Integer[] numbers = new Integer[LOTTO_NUMBER_LENGTH];

		for (Integer i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
			numbers[i] = Integer.parseInt(stringNumbers[i]);
		}

		return numbers;
	}
}
