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
			int count = ticket.countSameNumbers(answer);
			int temp = scores.get(count);
			scores.set(count, temp + 1);
		}
		return scores;
	}

	public static long sumPrizeMoney(List<Integer> scores) {
		long sum = 0;
		for (int i = 0; i < scores.size(); i++) {
			long money = Prize.valueOf(i).getPrize();
			sum += scores.get(i) * money;
		}
		return sum;
	}

	public static float convertToEarningRate(long totalPrizeMoney, int payment) {
		long difference = totalPrizeMoney - payment;
		return difference / (float)payment;
	}
}
