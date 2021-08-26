package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCard {
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 45;
	public static final List<Number> NUMBERS = new ArrayList<>();
	private static final LottoCard instance = new LottoCard();

	static {
		for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
			NUMBERS.add(new Number(i));
		}
	}

	private LottoCard() {
	}

	public static LottoCard getInstance() {
		return instance;
	}

	public Lotto issue() {
		Collections.shuffle(NUMBERS);
		List<Number> lottoNumbers = new ArrayList<>(NUMBERS.subList(0, 6));
		Numbers numbers = new Numbers(lottoNumbers);
		return new Lotto(numbers);
	}
}
