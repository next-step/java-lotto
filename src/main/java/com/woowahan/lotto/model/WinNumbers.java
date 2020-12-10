package com.woowahan.lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.woowahan.lotto.constant.Message;
import com.woowahan.lotto.util.ValidationUtil;

public class WinNumbers {

	private static final String DELIMITER_WIN_NUMBER = ",";

	private List<Integer> numbers;
	private int bonusNumber;

	public WinNumbers(String winNumbers, String bonusNumber) {
		List<String> result = validateWinNumber(winNumbers);
		this.numbers = result.stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		validateBonusNumber(bonusNumber, this.numbers);
		this.bonusNumber = Integer.parseInt(bonusNumber);
	}

	private void validateBonusNumber(String bonusNumber, List<Integer> numbers) {
		if (ValidationUtil.isNotNumber(bonusNumber) || ValidationUtil.isWrongNumber(bonusNumber)) {
			throw new IllegalArgumentException(Message.MSG_WRONG_BONUS_NUMBER);
		}
		if (findDuplicateNumber(bonusNumber, numbers)) {
			throw new IllegalArgumentException(Message.MSG_WRONG_DUPLICATE);
		}
	}

	private boolean findDuplicateNumber(String bonusNumber, List<Integer> numbers) {
		return numbers.stream()
			.anyMatch(number -> Integer.toString(number).equals(bonusNumber));
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

	public static WinNumbers of(String winNumbers, String bonusNumber) {
		return new WinNumbers(winNumbers, bonusNumber);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("WinNumbers{");
		sb.append("numbers=").append(numbers);
		sb.append(", bonusNumber=").append(bonusNumber);
		sb.append('}');
		return sb.toString();
	}
}
