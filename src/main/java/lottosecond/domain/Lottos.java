package lottosecond.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottoList = new ArrayList<>();

	public void buy(int money, LottoNumberGenerator generator) {
		buy(new Money(money), generator);
	}

	public void buy(Money money, LottoNumberGenerator generator) {
		int lottoCount = money.getLottoCount();
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

}
