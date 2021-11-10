package lotto.domain;

import java.util.Objects;

public class Statistics {
	private final Tickets tickets;
	private final Ticket winningNumberTicket;

	Statistics(Tickets tickets, Ticket winningNumberTicket) {
		this.tickets = tickets;
		this.winningNumberTicket = winningNumberTicket;
	}

	public static Statistics create(Tickets tickets, Ticket winningNumberTicket) {
		return new Statistics(tickets, winningNumberTicket);
	}

	public int getRankMatchedCount(Rank rank) {
		return (int)tickets.getValues().stream()
			.map(ticket -> ticket.getMatchedCount(winningNumberTicket))
			.filter(matchedCount -> matchedCount == rank.getCountOfMatch())
			.count();
	}

	public double calculateProfitRatio() {
		double winningAmount = tickets.getValues().stream()
			.map(ticket -> Rank.from(ticket.getMatchedCount(winningNumberTicket)))
			.mapToDouble(Rank::getWinningMoney)
			.sum();

		int purchasePrice = tickets.getValues().size() * Ticket.PRICE;
		return winningAmount / purchasePrice;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Statistics that = (Statistics)obj;

		if (!Objects.equals(tickets, that.tickets)) {
			return false;
		}
		return Objects.equals(winningNumberTicket, that.winningNumberTicket);
	}

	@Override
	public int hashCode() {
		int result = tickets != null ? tickets.hashCode() : 0;
		result = 31 * result + (winningNumberTicket != null ? winningNumberTicket.hashCode() : 0);
		return result;
	}
}
