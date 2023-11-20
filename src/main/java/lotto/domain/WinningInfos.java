package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningInfos {
	private List<WinningInfo> winningInfos = new ArrayList<>();

	public WinningInfos(List<WinningInfo> winningInfos) {
		this.winningInfos = winningInfos;
	}

	public Double sumAmountEachRank() {
		return winningInfos.stream()
			.mapToDouble(WinningInfo::calcTotalAmount)
			.sum();
	}
}
