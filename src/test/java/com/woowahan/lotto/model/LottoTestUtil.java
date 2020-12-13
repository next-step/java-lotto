package com.woowahan.lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTestUtil {

	public static List<LottoNo> convertLottoNo(List<Integer> numbers) {
		return numbers.stream()
			.map(LottoNo::of)
			.collect(Collectors.toList());
	}
}
