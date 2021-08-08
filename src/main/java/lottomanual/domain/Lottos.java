package lottomanual.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lottos {

	private final List<Lotto> lottos = new ArrayList<>();

	public Lottos() {}

	public Lottos(int money) {
		buy(new Money(money));
	}

	public Lottos(String[] lottoNumbers) {
		for (String lottoNumber : lottoNumbers) {
			lottos.add(new Lotto(lottoNumber));
		}
	}

	public Lottos(Set<LottoNumber> lottoNumbers) {
		buy(lottoNumbers);
	}

	public void buy(Set<LottoNumber> lottoNumbers) {
		lottos.add(new Lotto(lottoNumbers));
	}

	public void buy(Money money) {
		int lottoCount = money.getLottoCount();
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(new Lotto(LottoNumberShuffle.generate()));
		}
	}

	public int size() {
		return lottos.size();
	}

	public List<Lotto> toList() {
		return Collections.unmodifiableList(lottos);
	}

}
