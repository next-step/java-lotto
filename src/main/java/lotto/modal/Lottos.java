package lotto.modal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

	private final List<Lotto> lottos = new ArrayList<>();

	public List<Lotto> getLottos() {
		return this.lottos;
	}

	public void addManualLotto(String lotto) {
		this.lottos.add(Lotto.generateManualLotto(lotto));
	}

	public void generateRandomLotto(int randomCount) {
		this.lottos.addAll(generateRandomLottos(randomCount));
	}

	private List<Lotto> generateRandomLottos(int count) {
		return Stream.generate(Lotto::generateRandomLotto)
			.limit(count)
			.collect(Collectors.toList());
	}

}
