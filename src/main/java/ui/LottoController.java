package ui;

import domain.Lotto;
import domain.LottoOrderGroup;
import domain.LottoOrderGroupStatics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static domain.Lotto.LOTTO_NUMBER_LENGTH;
import static domain.Lotto.LOTTO_PRICE;
import static ui.IOMessage.*;
import static util.InputValidation.*;

public class LottoController {
	private final Scanner scanner = new Scanner(System.in);

	public void insertMoney() {
		while (true) {
			System.out.println(ASK_INSERTMONEY);

			String inputMoney = scanner.nextLine().trim();

			if (!checkInputMoney(inputMoney)) continue;

			final Integer lottoAmount = calcLottoAmount(inputMoney);

			System.out.println(lottoAmount + PURCHASE_MENT_SURFIX);

			final LottoOrderGroup lottoOrderGroup = new LottoOrderGroup(lottoAmount);

			printOrderGroup(lottoOrderGroup);

			System.out.println(); // 줄바꿈용
			System.out.println(ASK_LOTTO_WINNER_NUMBER);

			final Lotto winnerNumbers = askLottoWinnerNumber();

			System.out.println(ASK_LOTTO_BONUS_BALL);

			final Integer bonusBall = askBonusNumber(winnerNumbers);

			LottoOrderGroupStatics analysis = new LottoOrderGroupStatics(winnerNumbers, bonusBall, lottoOrderGroup.lottos());
			analysis.matchSetting();

			printAnalysis(analysis);
		}
	}

	private Integer askBonusNumber(Lotto winnerNumbers) {
		while (true) {
			String bonusInput = scanner.nextLine().trim();

			if (!checkInputLottoNumber(bonusInput)) continue;
			Integer bonusNumber = parseInteger(bonusInput);

			if (!isContainBonus(winnerNumbers, bonusNumber)) continue;

			return bonusNumber;
		}
	}

	private Lotto askLottoWinnerNumber() {
		while (true) {
			String winnerLottoNumber = scanner.nextLine().trim();
			if (!checkInputLottoNumbers(winnerLottoNumber)) continue;
			return setWinnerNumbers(winnerLottoNumber);
		}
	}

	private Integer calcLottoAmount(String inputMoney) {
		return Integer.parseInt(inputMoney) / LOTTO_PRICE;
	}

	private void printOrderGroup(LottoOrderGroup group) {
		for (Lotto lotto : group.lottos()) {
			System.out.println(lotto);
		}
	}

	private void printAnalysis(LottoOrderGroupStatics analysis) {
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

	private Lotto setWinnerNumbers(String winnerNumbers) {
		String[] stringNumbers = winnerNumbers.split(",");
		List<Integer> lotto = new ArrayList<>();

		for (int i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
			lotto.add(Integer.parseInt(stringNumbers[i]));
		}

		return new Lotto(lotto);
	}
}
