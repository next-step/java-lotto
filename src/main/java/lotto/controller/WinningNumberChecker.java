package lotto.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.domain.Digit;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Winners;

public final class WinningNumberChecker {
	public static int[] check(final List<Digit> winningNumbers, final List<Lottos> lottosList, final int number) {
		int[] numbersOfMatch = new int[number];
		Set<Lotto> lottoSet = new HashSet<>();

		for (Digit winningNumber : winningNumbers) {
			Lotto lotto = Lotto.find(winningNumber);
			lottoSet.add(lotto);
		}

		Winners winners = new Winners(Winners.winningNumbers(lottoSet));
		for (int i = 0; i < lottosList.size(); i++) {
			numbersOfMatch[i] = winners.countWinningNumbers(lottosList.get(i).lottos());
		}

		return numbersOfMatch;
	}
}
