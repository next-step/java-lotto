package step2.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixLottoGenerator implements LottoGenerator {

	private static final String DELIMITER = ",";

	private final String fixedNumber;

	public FixLottoGenerator(String fixedNumber) {
		this.fixedNumber = fixedNumber;
	}

	@Override
	public List<Integer> generating() {
		return Arrays.stream(fixedNumber.split(DELIMITER))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());
	}
}
