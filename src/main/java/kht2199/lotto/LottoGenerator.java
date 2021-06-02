package kht2199.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kht2199.lotto.entity.LottoList;
import kht2199.lotto.entity.Lotto;
import kht2199.lotto.entity.LottoNumber;
import kht2199.lotto.exception.number.LottoNumberException;

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
		try {
			return LottoNumber.valuesOf(numbers.subList(0, 6), true);
		} catch (LottoNumberException e) {
			// 1~46 이외의 숫자는 발생하지 않음.
			throw new RuntimeException(e);
		}
	}

	public LottoList randoms(int countsOfLotto) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < countsOfLotto; i++) {
			lottos.add(random());
		}
		return new LottoList(lottos);
	}
}
