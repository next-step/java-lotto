package lottomanual.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lottos {

	private final List<Lotto> lottos = new ArrayList<>();

	public Lottos() {}

	public Lottos(int money, Set<LottoNumber> lottoNumbers) {
		buy(new Money(money), lottoNumbers);
	}

	public Lottos(String[] lottoNumbers) {
		for (String lottoNumber : lottoNumbers) {
			lottos.add(new Lotto(lottoNumber));
		}
	}

	public void buy(int money, Set<LottoNumber> lottoNumbers) {
		buy(new Money(money), lottoNumbers);
	}

	public void buy(Money money, Set<LottoNumber> lottoNumbers) {
		int lottoCount = money.getLottoCount();
		for (int i = 0; i < lottoCount; i++) {
			addLotto(lottoNumbers);
		}
	}

	private void addLotto(Set<LottoNumber> lottoNumbers) {
		Lotto lotto = new Lotto(lottoNumbers);
		lottos.add(lotto);
	}

	public int size() {
		return lottos.size();
	}

	public List<Lotto> toList() {
		return Collections.unmodifiableList(lottos);
	}

}
