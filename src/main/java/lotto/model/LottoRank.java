package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {

	FOURTH(3, 5_000),
	THIRD(4, 50_000),
	SECOND(5, 1_500_000),
	FIRST(6, 2_000_000_000),
	BLANK(0, 0);


	private final int rank;
	private final int money;

	private static final int OK = 1;
	private static final int NOT_FOUND = 0;

	LottoRank(int rank, int money) {
		this.rank = rank;
		this.money = money;
	}

	public static LottoRank match(List<Integer> winning, List<Integer> random) {
		int count = 0;
		for (Integer number : winning) {
			count += numberMatch(number, random);
		}
		return LottoRank.lottoRank(count);
	}

	private static int numberMatch(int number, List<Integer> random) {
		if (random.contains(number)) {
			return OK;
		}
		return NOT_FOUND;
	}

	private static LottoRank lottoRank(int rank) {
		return Arrays.stream(values())
				.filter(lottoRank -> lottoRank.rank == rank)
				.findAny()
				.orElse(LottoRank.BLANK);
	}

	public int money() {
		return this.money;
	}

	public int rank() {
		return this.rank;
	}

}
