package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
	FIRST(6, 2000000000),
	SECOND(5, 1500000),
	THIRD(4, 50000),
	FOURTH(3, 5000);

	private int lottoCount;
	private int money;

	LottoRank(int lottoCount, int money) {
		this.lottoCount = lottoCount;
		this.money = money;
	}

	public static LottoRank findLottoRankByLottoCount(int lottoCount) {
		return Arrays.stream(LottoRank.values())
				.filter(v -> v.lottoCount == lottoCount)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("존재 할 수 없는 값입니다."));
	}

	public int getLottoCount() {
		return lottoCount;
	}

	public int getMoney() {
		return money;
	}

}
