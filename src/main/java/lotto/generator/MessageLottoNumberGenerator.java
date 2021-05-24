package lotto.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import calculator.StringCalculator;
import lotto.LottoNumber;
import lotto.LottoNumbers;

public class MessageLottoNumberGenerator implements Generator {

	private final List<Integer> numbers;

	public MessageLottoNumberGenerator(String message) {
		List<String> numbers = Arrays.asList(StringCalculator.tokenizing(message, ", "));
		this.numbers = new ArrayList<>();
		for (String number : numbers) {
			this.numbers.add(Integer.valueOf(number));
		}
	}

	@Override
	public LottoNumbers generate() {
		Collections.sort(numbers);
		List<LottoNumber> lottoNumberList = convertTo(numbers);
		return appendLottoNumber(lottoNumberList);
	}

	private List<LottoNumber> convertTo(List<Integer> numbers) {
		return numbers.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	private LottoNumbers appendLottoNumber(List<LottoNumber> lottoNumberList) {
		LottoNumbers lottoNumbers = new LottoNumbers();
		for (LottoNumber lottoNumber : lottoNumberList) {
			lottoNumbers.add(lottoNumber);
		}
		return lottoNumbers;
	}
}
