package step2.domain;

import java.util.List;

public class LottoResult {
	List<Lotto> Lottos;

	public int getLottoAmount() {
		return Lottos.size();
	}

	public void addHistory(List<Lotto> lotto) {
		Lottos.addAll(lotto);
	}
}
