package com.java.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lotto {
	public static final int LOTTO_PRICE = 1000;

	private final int purchaseAmount;
	private final LottoTickets lottoTickets;

	private WinningStatistics winningStatistics;

	public Lotto(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
		this.lottoTickets = purchase(purchaseAmount);
		this.winningStatistics = new WinningStatistics();
	}

	private LottoTickets purchase(int purchaseAmount) {
		return LottoTicketsGenerator.automaticTicketsGenerator(purchaseAmount / LOTTO_PRICE);
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets.getLottoTickets();
	}

	public int getLottoTicketsCount() {
		return lottoTickets.count();
	}

	public float rateOfReturn() {
		return winningStatistics.rateOfReturn(purchaseAmount);
	}


	public Map<LottoReward, Integer> getWinningStatistics() {
		return winningStatistics.getReward();
	}

	public Integer countByReward(LottoReward lottoReward){
		return winningStatistics.countByReward(lottoReward) == null ? 0 :winningStatistics.countByReward(lottoReward);
	}


	public void winningNumbers(String winningNumbers, int bonusNumber) {
		winningStatistics.findLottoWinning(new WinningNumbers(winningNumbers, bonusNumber), lottoTickets);
	}
}
