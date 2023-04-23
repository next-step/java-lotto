package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

	private final List<Lotto> lottos;

	public LottoMachine(int buyCount) {
		this.lottos = new ArrayList<>();

		for (int i = 0; i < buyCount; i++) {
			this.lottos.add(new Lotto());
		}
	}

	public int lottosSize() {
		return this.lottos.size();
	}
}
