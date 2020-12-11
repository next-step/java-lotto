package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class GenerateLottoNumber {
	public static LottoNumbers manual(List<Integer> manualNumbers) {
		return manualNumbers.stream()
			.map(LottoNumber::new)
			.sorted(LottoNumber::isGraterThanNumber)
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::new));
	}
}
