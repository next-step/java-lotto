package lotto;

import java.util.Collections;
import java.util.List;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = Collections.unmodifiableList(lottos);
	}

	public int count() {
		return lottos.size();
	}

	public List<Lotto> findAll() {
		return lottos;
	}
}
