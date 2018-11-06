package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hspark on 06/11/2018.
 */
public class ShuffleLottoMachine implements LottoMachine {
	private List<Integer> lottoNumbers;

	public ShuffleLottoMachine() {
		this.lottoNumbers = Stream.iterate(0, i -> i + 1).limit(45).collect(Collectors.toList());
	}

	@Override
	public List<Integer> draw() {
		return Arrays.asList();
	}
}
