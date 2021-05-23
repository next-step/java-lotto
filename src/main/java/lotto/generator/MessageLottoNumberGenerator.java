package lotto.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import calculator.StringCalculator;
import lotto.LottoNumber;
import lotto.LottoNumbers;
import lotto.converter.NumberToLotto;

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
	public void generate(LottoNumbers lottoNumbers) {
		Collections.sort(numbers);
		List<LottoNumber> lottoNumberList = NumberToLotto.convert(numbers);
		appendLottoNumber(lottoNumbers, lottoNumberList);
	}

	private void appendLottoNumber(LottoNumbers lottoNumbers, List<LottoNumber> lottoNumberList) {
		for (LottoNumber lottoNumber : lottoNumberList) {
			lottoNumbers.add(lottoNumber);
		}
	}
}
