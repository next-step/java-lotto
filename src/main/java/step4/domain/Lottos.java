package step4.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = new ArrayList<>(lottos);
	}

	public static Lottos createAutoLottos(int autoLottoCount) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < autoLottoCount; i++) {
			lottos.add(Lotto.auto());
		}
		return new Lottos(lottos);
	}

	public static Lottos createManualLottos(String[] inputLottos) {
		return new Lottos(Arrays.stream(inputLottos)
				.map(Lotto::manual)
				.collect(Collectors.toList())
		);
	}

	public int size() {
		return lottos.size();
	}

	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}

	public Map<Rank, Integer> getLottosMap(WinningLotto winningLotto) {
		Map<Rank, Integer> lottoResultMap = new EnumMap<>(Rank.class);
		Rank rank;
		for (Lotto lotto : this.lottos) {
			rank = winningLotto.getMatchRank(lotto);
			lottoResultMap.put(rank, lottoResultMap.getOrDefault(rank, 0)+1);
		}
		return lottoResultMap;
	}

	public Lottos addLottos(Lottos lottos) {
		this.lottos.addAll(lottos.lottos);
		return new Lottos(this.lottos);
	}
}
