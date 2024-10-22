package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoHistory {
	List<Lotto> lottoHistory;

	public void addHistory(List<Lotto> lotto) {
		lottoHistory = new ArrayList<>(lotto);
	}

	public List<Lotto> getHistory() {
		return lottoHistory;
	}
}
