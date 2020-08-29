package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos() {
		lottos = new ArrayList<>();
	}

	public int size() {
		return lottos.size();
	}

	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}

	public Lottos getAllLottos(int lottoCount, List<Lotto> manualLottos) {
		lottos.addAll(manualLottos);
		int v = getManualLottoCount();
		setAutoLottos(lottoCount - getManualLottoCount());
		return this;
	}

	public int getManualLottoCount() {
		return (int) lottos.stream()
				.filter(Lotto::isManual)
				.count();
	}

	private void setAutoLottos(int autoLottoCount) {
		for (int i = 0; i < autoLottoCount; i++) {
			lottos.add(Lotto.auto());
		}
	}

}
