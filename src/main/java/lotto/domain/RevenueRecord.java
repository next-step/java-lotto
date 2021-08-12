package lotto.domain;

import java.util.List;

public class RevenueRecord {

	private final List<Lotto> lottos;
	private final Records records;

	public RevenueRecord(List<Lotto> lottos) {
		this.lottos = lottos;
		this.records = new Records();
	}

	public Records aggregate(WinLotto winLotto) {
		lottos.forEach(lotto -> addRecord(lotto, winLotto));

		return records;
	}

	private void addRecord(Lotto lotto, WinLotto winLotto) {
		records.addRecord(lotto.figureOutRank(winLotto));
	}
}
