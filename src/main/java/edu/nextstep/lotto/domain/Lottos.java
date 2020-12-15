package edu.nextstep.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<List<Integer>> lottos) {
		this.lottos = lottos.stream()
			.map(Lotto::new)
			.collect(Collectors.toList());
	}
}