package wootecam.lotto.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import wootecam.lotto.model.Lotto;

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

	protected Lotto getNumbers() {
		Collections.shuffle(this.autoLottoNumbers);
		List<Integer> autoNumberList = this.autoLottoNumbers.subList(0, 6);
		Collections.sort(autoNumberList);
		return new Lotto(autoNumberList);
	}
}
