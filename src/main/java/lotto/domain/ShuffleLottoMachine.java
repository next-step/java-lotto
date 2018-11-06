package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hspark on 06/11/2018.
 */
public class ShuffleLottoMachine implements LottoMachine {

	@Override
	public List<Integer> draw() {
		List<Integer> numberList = Stream.iterate(1, i -> i + 1).limit(45).collect(Collectors.toList());
		Collections.shuffle(numberList);
		return numberList.subList(0, 6);
	}
}
