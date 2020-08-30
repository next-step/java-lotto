package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> manualLottos) {
		lottos = new ArrayList<>(manualLottos);
	}

	public int size() {
		return lottos.size();
	}

	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}

	public void addLottos(Lottos lottos) {
		this.lottos.addAll(lottos.lottos);
	}
}
