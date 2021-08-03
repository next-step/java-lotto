package lottoautomatic.domain;

import java.util.*;

public class Lottos {

	private static final int AMOUNT_UNIT = 1_000;

	private final List<Lotto> lottoList = new ArrayList<>();

	public void buy(int amount, LottoNumberGenerator generator) {
		int lottoCount = amount / AMOUNT_UNIT;
		for (int i = 0; i < lottoCount; i++) {
			addLotto(generator);
		}
	}

	private void addLotto(LottoNumberGenerator generator) {
		Lotto lotto = new Lotto(generator.generate());
		lottoList.add(lotto);
	}

	public int size() {
		return lottoList.size();
	}

	public List<Lotto> toList() {
		return Collections.unmodifiableList(lottoList);
	}

	public int totalAmount() {
		return AMOUNT_UNIT * size();
	}

}
