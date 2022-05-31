package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoGroupFactory {
	public static List<Lotto> createAuto(long quantity) {

		return LongStream.rangeClosed(1, quantity)
			.mapToObj(num -> Lotto.createAuto())
			.collect(Collectors.toList());
	}

	public static List<Lotto> createManual(List<String> customerLottoGroup) {
		return customerLottoGroup.stream()
			.map(input -> Lotto.createManual(Arrays.stream(input.split(Lotto.SPLIT_DELIMITER))
				.map(LottoNumber::from)
				.collect(Collectors.toSet())))
			.collect(Collectors.toList());
	}
}
