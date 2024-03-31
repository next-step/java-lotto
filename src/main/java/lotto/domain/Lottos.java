package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
	private final List<Lotto> lottos = new ArrayList<>();

	public void add(Lotto lotto) {
		lottos.add(lotto);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
