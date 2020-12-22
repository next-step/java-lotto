package step2.domain;

import java.util.Arrays;
import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(final Lotto... lottos) {
		this(Arrays.asList(lottos));
	}

	public Lottos(final List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public int size() {
		return this.lottos.size();
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

}
