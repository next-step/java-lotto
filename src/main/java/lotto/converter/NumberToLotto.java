package lotto.converter;

import java.util.ArrayList;
import java.util.List;

import lotto.LottoNumber;

public class NumberToLotto {

	private NumberToLotto() {
	}

	public static LottoNumber convert(int number) {
		return new LottoNumber(number);
	}

	public static List<LottoNumber> convert(List<Integer> numbers) {
		List<LottoNumber> result = new ArrayList<>(numbers.size());
		for (int number : numbers) {
			result.add(convert(number));
		}
		return result;
	}
}
