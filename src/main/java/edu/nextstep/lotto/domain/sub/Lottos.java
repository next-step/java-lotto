package edu.nextstep.lotto.domain.sub;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<List<Integer>> lottos) {
		this.lottos = lottos.stream()
			.map(Lotto::new)
			.collect(Collectors.toList());
	}

	public Map<LottoRank, Long> getResultAsCountingMap(WinningLotto winningLotto) {
		return lottos.stream()
			.map(lotto -> lotto.getRank(winningLotto))
			.filter(Optional::isPresent)
			.map(Optional::get)
			.collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
	}

	public int size() {
		return lottos.size();
	}

	public List<List<Integer>> toList() {
		return lottos.stream()
			.map(lotto -> lotto.getLottoNumbers().toList())
			.collect(Collectors.toList());
	}
}