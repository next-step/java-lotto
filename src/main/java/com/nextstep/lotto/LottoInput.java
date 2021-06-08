package com.nextstep.lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.nextstep.lotto.lotto.Lotto;
import com.nextstep.lotto.lotto.LottoNumber;

public class LottoInput {
	private static final String SPLIT_REGEX = ",";
	private static final String NUMBER_CHECK_REGEX = "\\d+";
	private static final String MESSAGE_ONLY_NUMBERS_CAN_ENTER = "숫자만 입력가능합니다.";

	private static final Scanner scanner = new Scanner(System.in);

	public int inputMoney() {
		return Integer.parseInt(scanner.nextLine());
	}

	public Lotto inputWinningNumber() {
		String input = scanner.nextLine();
		String[] winningNumber = convertStringToArray(input);
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		for (String number : winningNumber) {
			lottoNumbers.add(new LottoNumber(convertStringToInt(number)));
		}

		return new Lotto(lottoNumbers);
	}

	private String[] convertStringToArray(String input) {
		return input.split(SPLIT_REGEX);
	}

	private int convertStringToInt(String input) {
		if (!input.matches(NUMBER_CHECK_REGEX)) {
			throw new IllegalArgumentException(MESSAGE_ONLY_NUMBERS_CAN_ENTER);
		}
		return Integer.parseInt(input);
	}
}
