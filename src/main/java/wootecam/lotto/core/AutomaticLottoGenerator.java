package wootecam.lotto.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoNumber;

public class AutomaticLottoGenerator {

	public static final int CAPACITY = 45;
	public static final int FIRST_VALUE = 1;
	private final List<Integer> autoLottoNumbers = new ArrayList<>(CAPACITY);

	public AutomaticLottoGenerator() {
		this.init();
	}

	private void init() {
		for (int i = FIRST_VALUE; i <= CAPACITY; i++) {
			this.autoLottoNumbers.add(i);
		}
	}

	protected Lotto getLotto() {
		Collections.shuffle(this.autoLottoNumbers);
		List<Integer> autoNumberList = this.autoLottoNumbers.subList(0, 6);

		List<LottoNumber> lotto = autoNumberList.stream()
			.map(LottoNumber::of)
			.sorted()
			.collect(Collectors.toList());

		return new Lotto(lotto);
	}
}
