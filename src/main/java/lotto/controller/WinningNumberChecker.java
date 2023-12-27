package lotto.controller;

import java.util.List;

import lotto.domain.Lottos;
import lotto.domain.Ticket;

public class WinningNumberChecker {
	public static int[] check(final List<Integer> winningNumbers, final List<Lottos> lottosList, final int number) {
		int[] numbersOfMatch = new int[number];

		Ticket ticket = new Ticket(lottosList);

		for (int i = 0; i < lottosList.size(); i++) {
			numbersOfMatch[i] = ticket.compareTo(winningNumbers, i);
		}

		return numbersOfMatch;
	}
}
