package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum LottoRank {
	FIRST(6, 2000000000),
	SECOND(7, 1500000),
	THIRD(8, 50000),
	FOURTH(9, 5000),
	BLANK(12, 0);


	private int rank;
	private int money;

	LottoRank(int rank, int money) {
		this.rank = rank;
		this.money = money;
	}

	public static int moneyByRank(int rank) {
		for (LottoRank lottoRank : values()) {
			if (lottoRank.rank == rank) {
				return lottoRank.money;
			}
		}
		return LottoRank.BLANK.money;
	}

	public static int match(List<Integer> winning, List<Integer> random) {
		Set<Integer> set = new HashSet<>();
		set.addAll(winning);
		set.addAll(random);
		return LottoRank.moneyByRank(set.size());
	}

	public int money() {
		return this.money;
	}

}
