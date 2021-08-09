package lottomanual.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lottos {

	private final List<Lotto> lottos = new ArrayList<>();

	public Lottos() {}

	public Lottos(int money) {
		buy(Money.of(money));
	}

	public Lottos(int money, String[] manualNumbers) {
		for (String lottoNumber : manualNumbers) {
			lottos.add(Lotto.of(lottoNumber));
		}
		Money automaticAmount = Money.of(money).excludeLottoCount(manualNumbers.length);
		buy(automaticAmount);
	}

	public Lottos(String[] lottoNumbers) {
		for (String lottoNumber : lottoNumbers) {
			lottos.add(Lotto.of(lottoNumber));
		}
	}

	public Lottos(Set<LottoNumber> lottoNumbers) {
		buy(lottoNumbers);
	}

	public void buy(Set<LottoNumber> lottoNumbers) {
		lottos.add(Lotto.of(lottoNumbers));
	}

	public void buy(int money) {
		buy(Money.of(money));
	}

	public void buy(Money money) {
		int lottoCount = money.getLottoCount();
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(Lotto.of(LottoNumberShuffle.generate()));
		}
	}

	public int size() {
		return lottos.size();
	}

	public List<Lotto> toList() {
		return Collections.unmodifiableList(lottos);
	}

}
