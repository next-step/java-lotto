package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoCard {
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 45;
	public static final List<Integer> NUMBERS = new ArrayList<>();
	private static final LottoCard instance = new LottoCard();

	static {
		for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
			NUMBERS.add(i);
		}
	}

	private LottoCard() {
	}

	public static LottoCard getInstance() {
		return instance;
	}

	public Lotto issue() {
		Collections.shuffle(NUMBERS);
		List<Integer> numbers = new ArrayList<>(NUMBERS.subList(0, 6));
		List<Number> lottoNumbers = numbers.stream()
			.sorted()
			.map(Number::new)
			.collect(Collectors.toList());
		return new Lotto(lottoNumbers);
	}
}
