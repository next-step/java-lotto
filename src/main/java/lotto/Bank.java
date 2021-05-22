package lotto;

import java.util.Arrays;
import java.util.List;

import lotto.enums.Prize;

public final class Bank {

	private Bank() {
	}

	public static List<Integer> countScores(List<Ticket> tickets, Ticket answer) {
		List<Integer> scores = Arrays.asList(0, 0, 0, 0, 0, 0, 0);
		for (Ticket ticket : tickets) {
			int index = ticket.countSameNumbers(answer);
			int score = scores.get(index);
			scores.set(index, score + 1);
		}
		return scores;
	}

	public static long sumPrizeMoney(List<Integer> scores) {
		long sum = 0;
		for (int index = 0; index < scores.size(); index++) {
			long money = Prize.valueOf(index).getPrize();
			sum += scores.get(index) * money;
		}
		return sum;
	}

	public static float convertToEarningRate(long totalPrizeMoney, int payment) {
		long difference = totalPrizeMoney - payment;
		return difference / (float)payment;
	}
}
