package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

	private List<Lotto> lottos;

	public Lottos() {
		this.lottos = new ArrayList<>();
	}

	public int getSize() {
		return this.lottos.size();
	}

	public void addLotto(Lotto lotto) {
		this.lottos.add(lotto);
	}

	public void addAllLottos(Lottos lottos) {
		this.lottos.addAll(lottos.lottos);
	}

	public LottoResult getLottoResult(Lotto winningLotto, LottoNumber bonusNumber) {
		List<LottoRank> userLottoRanks = this.lottos.stream()
			.map(lotto ->
				LottoRank.valueOf(winningLotto.getMatchesCount(lotto), lotto.containNumber(bonusNumber))
			)
			.collect(Collectors.toList());
		return new LottoResult(userLottoRanks);
	}

	@Override
	public String toString() {
		return this.lottos.stream()
			.map(Lotto::toString)
			.collect(Collectors.joining("\n"));
	}

}
