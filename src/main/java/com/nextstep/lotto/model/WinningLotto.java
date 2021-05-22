package com.nextstep.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

	private static final String SPLIT_REGEX = ",";
	private static final String NUMBER_CHECK_REGEX = "\\d+";
	private Lotto winningLotto;

	public WinningLotto(String input) {
		String[] numbers = convertStringToArray(input);
		winningLotto = generateLotto(numbers);
	}

	public Lotto getWinningLotto() {
		return this.winningLotto;
	}

	private Lotto generateLotto(String[] numbers) {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (String number : numbers) {
			lottoNumbers.add(new LottoNumber(convertStringToInt(number)));
		}
		return new Lotto(lottoNumbers);
	}

	private String[] convertStringToArray(String input) {
		return input.split(SPLIT_REGEX);
	}

	private int convertStringToInt(String input) {
		if (!input.matches(NUMBER_CHECK_REGEX)) {
			throw new IllegalArgumentException("숫자만 입력가능합니다.");
		}
		return Integer.parseInt(input);
	}
}
