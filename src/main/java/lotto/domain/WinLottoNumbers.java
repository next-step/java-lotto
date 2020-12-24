package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.utils.ValidationUtils;

public class WinLottoNumbers {
	private final List<LottoNumber> lottoNumbers;

	public WinLottoNumbers(String lottoNumbers) {
		ValidationUtils.validateEmpty(lottoNumbers);
		this.lottoNumbers = Collections.unmodifiableList(mapToList(splitByComma(lottoNumbers)));
	}

	private String[] splitByComma(String numbers) {
		return numbers.split(Message.COMMA);
	}

	private List<LottoNumber> mapToList(String[] strings) {
		return Arrays.stream(strings)
			.map(String::trim)
			.map(this::parseInt)
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	private int parseInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(Message.INPUT_NUMBER);
		}
	}

	public List<LottoNumber> getWinNumbers() {
		return lottoNumbers;
	}
}
