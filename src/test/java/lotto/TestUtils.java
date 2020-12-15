package lotto;

import lotto.number.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtils {

	public static List<LottoNumber> toLottoNumberList(String numbers) {
		return Arrays.stream(numbers.split(","))
				.map(Integer::parseInt)
				.map(LottoNumber::new)
				.collect(Collectors.toList());
	}
}
