package kht2199.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kht2199.lotto.exception.number.LottoNumberException;

/**
 * 로또 번호 생성기.
 *
 * @author heetaek.kim
 */
public final class LottoGenerator {

	public LottoNumbers random() {
		List<Integer> numbers = IntStream.range(1, 46).boxed()
			.collect(Collectors.toList());
		Collections.shuffle(numbers);
		try {
			return LottoNumber.valuesOf(numbers.subList(0, 6));
		} catch (LottoNumberException e) {
			// 1~46 이외의 숫자는 발생하지 않음.
			throw new RuntimeException(e);
		}
	}
}
