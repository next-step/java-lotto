package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
	private List<Lotto> lottos;

	public Lottos() {
		lottos = new ArrayList<>(45);
	}

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> shuffle() {
		Collections.shuffle(lottos);
		return lottos;
	}

	public Lottos allLottoNumbers() {
		Stream<Lotto> allLottoNumbers = Arrays.stream(Lotto.values());
		return new Lottos(allLottoNumbers.collect(Collectors.toList()));
	}

	public Lotto indexOfLottos(int index) {
		return lottos.get(index);
	}

	public List<Lotto> lottos() {
		return lottos;
	}

	public List<Digit> digits() {
		return lottos.stream()
			.map(Lotto::digits)
			.collect(Collectors.toList());
	}
}
