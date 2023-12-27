package lotto.controller;

import java.util.List;

import lotto.domain.Lottos;
import lotto.domain.Ticket;

public final class WinningNumberChecker {
	public static int[] check(final int[] winningNumbers, final Ticket ticket, final int number) {
		int[] numbersOfMatch = new int[number];

		for (int i = 0; i < ticket.ticket().size(); i++) {
			numbersOfMatch[i] = ticket.compareTo(winningNumbers, i);
		}

		return numbersOfMatch;
	}
}
