package com.nextstep.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

	public Set<LottoNumber> inputNumber() {
		String input = scanner.nextLine();
		String[] winningNumber = convertStringToArray(input);
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		for (String number : winningNumber) {
			lottoNumbers.add(new LottoNumber(convertStringToInt(number)));
		}

		return lottoNumbers;
	}

	public LottoNumber inputBonusNumber() {
		String input = scanner.nextLine();
		return new LottoNumber(Integer.parseInt(input));
	}

	public int inputManualLottoCount() {
		return Integer.parseInt(scanner.nextLine());
	}

	public List<Lotto> inputManualLotto(int manualLottoCount) {
		List<Lotto> lottoList = IntStream.range(0, manualLottoCount)
			.mapToObj(i -> new Lotto(inputNumber()))
			.collect(Collectors.toList());
		return lottoList;
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
