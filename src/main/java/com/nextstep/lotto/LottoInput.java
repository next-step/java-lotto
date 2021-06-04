package com.nextstep.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nextstep.lotto.lotto.LottoNumber;

public class LottoInput {
	private static final String SPLIT_REGEX = ",";
	private static final String NUMBER_CHECK_REGEX = "\\d+";
	private static final String MESSAGE_ONLY_NUMBERS_CAN_ENTER = "숫자만 입력가능합니다.";

	private Scanner scanner = new Scanner(System.in);

	public int inputMoney() {
		return Integer.parseInt(scanner.nextLine());
	}

	public List<LottoNumber> inputWinningNumber() {
		String input = scanner.nextLine();
		String[] winningNumber = convertStringToArray(input);
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (String number : winningNumber) {
			lottoNumbers.add(new LottoNumber(convertStringToInt(number)));
		}

		return lottoNumbers;
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
