package step4.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> manualLottos) {
		this.lottos = manualLottos;
	}

	public static Lottos convertInputLottos(String[] inputLottos) {
		return new Lottos(Arrays.stream(inputLottos)
				.map(lotto -> Arrays.stream(lotto.split(", "))
						.map(Integer::new)
						.map(LottoNumber::new)
						.collect(Collectors.toList()))
				.map(Lotto::new)
				.collect(Collectors.toList()));
	}

	public int size() {
		return lottos.size();
	}

	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}

	public List<Integer> getMatchCounts(Lotto otherLotto) {
		return this.lottos.stream()
		.map(lotto -> otherLotto.getMatchCount(lotto))
		.collect(Collectors.toList());
	}

	public Lottos addLottos(Lottos lottos) {
		this.lottos.addAll(lottos.lottos);
		return new Lottos(this.lottos);
	}
}
