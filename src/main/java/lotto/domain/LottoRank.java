package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);

	private final int countOfMatch;
	private final int winningMoney;

	LottoRank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static LottoRank valueOfCount(int countOfMatch) {
		return Arrays.stream(LottoRank.values())
			.filter(lottoRank -> lottoRank.getCountOfMatch() == countOfMatch)
			.findFirst().orElse(LottoRank.MISS);
	}

	public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
		List<LottoRank> lottoRank = Arrays.stream(LottoRank.values())
			.filter(lr -> lr.getCountOfMatch() == countOfMatch)
			.collect(Collectors.toList());
		if (lottoRank.isEmpty()) {
			return LottoRank.MISS;
		}
		if (lottoRank.size() == 2 && matchBonus) {
			return lottoRank.get(0);
		}
		if (lottoRank.size() == 2) {
			return lottoRank.get(1);
		}
		return lottoRank.get(0);
	}
}
