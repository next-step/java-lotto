package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;

import java.util.ArrayList;
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

	public static LottoNumbers createLottoNumbers(int n1, int n2, int n3, int n4, int n5, int n6) {
		List<LottoNumber> lottoNumberList = Arrays.asList(
				new LottoNumber(n1), new LottoNumber(n2), new LottoNumber(n3),
				new LottoNumber(n4), new LottoNumber(n5), new LottoNumber(n6));
		return new LottoNumbers(lottoNumberList);
	}

	public static List<LOTTO_RESULT> duplicate(LOTTO_RESULT lottoResult, int size) {
		List<LOTTO_RESULT> resultList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			resultList.add(lottoResult);
		}
		return resultList;
	}
}
