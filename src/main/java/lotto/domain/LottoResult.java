package lotto.domain;

public class LottoResult {

	private static final int FIRST_RANK_EARNING = 2000000000;
	private static final int SECOND_RANK_EARNING = 1500000;
	private static final int THIRD_RANK_EARNING = 50000;
	private static final int FORTH_RANK_EARNING = 5000;

	private static final int FIRST_RANK_MATCH_COUNT = 6;
	private static final int SECOND_RANK_MATCH_COUNT = 5;
	private static final int THIRD_RANK_MATCH_COUNT = 4;
	private static final int FORTH_RANK_MATCH_COUNT = 3;

	private int firstRankCount;
	private int secondRankCount;
	private int thirdRankCount;
	private int fourthRankCount;
	private long earning;
	private double earningsRate;

	public int getFirstRankCount() {
		return firstRankCount;
	}

	public int getSecondRankCount() {
		return secondRankCount;
	}

	public int getThirdRankCount() {
		return thirdRankCount;
	}

	public int getFourthRankCount() {
		return fourthRankCount;
	}

	public long getEarning() {
		return earning;
	}

	public double getEarningsRate() {
		return earningsRate;
	}

	public void makeResult(LottoTickets lottoTickets, WinningNumbers winningNumbers, int purchaseAmount) {
		for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
			compareTicket(lottoTicket, winningNumbers);
		}
		calculateEarning();
		calculateEarningRate(purchaseAmount);
	}

	private void compareTicket(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
		int matchCount = 0;
		for (int number : lottoTicket.getTicketNumbers()) {
			matchCount = compareTicketNumber(number, winningNumbers, matchCount);
		}

		if (matchCount == FORTH_RANK_MATCH_COUNT) {
			fourthRankCount++;
		}

		if (matchCount == THIRD_RANK_MATCH_COUNT) {
			thirdRankCount++;
		}

		if (matchCount == SECOND_RANK_MATCH_COUNT) {
			secondRankCount++;
		}

		if (matchCount == FIRST_RANK_MATCH_COUNT) {
			firstRankCount++;
		}
	}

	private int compareTicketNumber(int number, WinningNumbers winningNumbers, int matchCount) {
		if (winningNumbers.getWinningNumbers().contains(number)) {
			matchCount++;
		}
		return matchCount;
	}

	private long calculateEarning() {
		return earning = (firstRankCount * FIRST_RANK_EARNING) +
			     	     (secondRankCount * SECOND_RANK_EARNING) +
				         (thirdRankCount * THIRD_RANK_EARNING) +
				         (fourthRankCount * FORTH_RANK_EARNING);
	}

	private double calculateEarningRate(int purchaseAmount) {
		return earningsRate = (double)earning / purchaseAmount;
	}
}
