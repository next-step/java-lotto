package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Statistics {
	private final Tickets tickets;
	private final Ticket winningNumberTicket;
	private final Map<Rank, Integer> matchedResult;
	private final double profitRatio;

	private Statistics(Tickets tickets, Ticket winningNumberTicket) {
		this.tickets = tickets;
		this.winningNumberTicket = winningNumberTicket;
		this.matchedResult = calculateMatchedResult();
		this.profitRatio = calculateProfitRatio();
	}

	private Map<Rank, Integer> calculateMatchedResult() {
		return Arrays.stream(Rank.values())
			.collect(Collectors.toMap(Function.identity(), this::getRankMatchedCount));
	}

	private int getRankMatchedCount(Rank rank) {
		return tickets.getRankMatchedCount(rank, winningNumberTicket);
	}

	private double calculateProfitRatio() {
		return tickets.calculateProfitRatio(winningNumberTicket);
	}

	public static Statistics create(Tickets tickets, Ticket winningNumberTicket) {
		return new Statistics(tickets, winningNumberTicket);
	}

	public Map<Rank, Integer> getMatchedResult() {
		return Collections.unmodifiableMap(matchedResult);
	}

	public double getProfitRatio() {
		return profitRatio;
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
