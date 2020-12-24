package lotto.modal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

	private final List<Lotto> lottos = new ArrayList<>();

	public Lottos() {
	}

	public Lottos(int count) {

		this.lottos = generateRandomLotto(count);
	}

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}

	private List<Lotto> generateRandomLotto(int count) {
		return Stream.generate(Lotto::new)
			.limit(count)
			.collect(Collectors.toList());
	}

	public List<Lotto> mergeLotto(Lottos randomLotto) {
		return Stream.concat(this.lottos.stream(), randomLotto.getLottos().stream())
			.collect(Collectors.toList());
	}

	public void addLotto(String lotto) {
		this.lottos.add(Lotto.generateLotto(lotto));
	}
}
