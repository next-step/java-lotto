package step2.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixLottoGenerator implements LottoGenerator {

	private final String fiexdNumber;

	public FixLottoGenerator(String fixedNumber) {
		this.fiexdNumber = fixedNumber;
	}

	@Override
	public List<Integer> generating() {
		return Arrays.stream(fiexdNumber.split(","))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());
	}
}
