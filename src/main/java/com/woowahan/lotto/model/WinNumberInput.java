package com.woowahan.lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.woowahan.lotto.constant.Message;
import com.woowahan.lotto.util.ValidationUtil;

public class WinNumberInput {

	private static final String DELIMITER_WIN_NUMBER = ",";

	private List<Integer> winNumbers;

	public WinNumberInput(String input) {
		List<String> result = validateWinNumber(input);
		this.winNumbers = result.stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private List<String> validateWinNumber(String input) {
		if (ValidationUtil.isNullOrEmpty(input)) {
			throw new IllegalArgumentException(Message.MSG_NULL_OR_EMPTY);
		}
		List<String> result = parseWinNumbers(input);
		if (result.size() != Lotto.LOTTO_NUMBER_LENGTH
			|| ValidationUtil.hasNotNumber(result)
			|| ValidationUtil.hasWrongNumber(result)) {
			throw new IllegalArgumentException(Message.MSG_WRONG_WIN_NUMBER);
		}
		return result;
	}

	private List<String> parseWinNumbers(String input) {
		String[] splitNames = input.split(DELIMITER_WIN_NUMBER);
		return Arrays.stream(splitNames)
			.map(String::trim)
			.collect(Collectors.toList());
	}

	public static WinNumberInput of(String input) {
		return new WinNumberInput(input);
	}

	public List<Integer> getWinNumbers() {
		return winNumbers;
	}
}
