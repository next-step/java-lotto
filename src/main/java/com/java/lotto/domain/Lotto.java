package com.java.lotto.domain;

import java.util.List;

public class Lotto {
	private static final int LOTTO_PRICE = 1000;
	private static final int ZERO_COUNT = 0;

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

	public Integer countByReward(LottoReward lottoReward){
		return winningStatistics.countByReward(lottoReward) == null ? ZERO_COUNT :winningStatistics.countByReward(lottoReward);
	}

	public void winningNumbers(String winningNumbers, int bonusNumber) {
		winningStatistics.findLottoWinning(new WinningTicket(winningNumbers, bonusNumber), lottoTickets);
	}
}
