package kht2199.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kht2199.lotto.data.Lotto;

/**
 * 로또 번호 생성기.
 *
 * @author heetaek.kim
 */
public final class LottoGenerator {

	public Lotto random() {
		List<Integer> numbers = IntStream.range(1, 46).boxed()
			.collect(Collectors.toList());
		Collections.shuffle(numbers);
		return new Lotto(numbers.subList(0, 6));
	}
}
