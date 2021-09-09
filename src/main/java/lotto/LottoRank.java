package lotto;

import java.util.Arrays;

public enum LottoRank {
	FIRST(6, false, 2_000_000_000) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return this.isSameMatchCount(matchCount);
		}
	},

	SECOND(5, true, 30_000_000) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return this.isSameMatchCount(matchCount) && this.isMatchBonus == isMatchBonus;
		}
	},

	THIRD(5, false, 1_500_000) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return this.isSameMatchCount(matchCount) && this.isMatchBonus == isMatchBonus;
		}
	},

	FOURTH(4, false, 50_000) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return this.isSameMatchCount(matchCount);
		}
	},

	FIFTH(3, false, 5_000) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return this.isSameMatchCount(matchCount);
		}
	},

	NOTHING(2, false, 0) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return matchCount <= this.matchCount;
		}
	};

	private final int reward;
	protected final int matchCount;
	protected final boolean isMatchBonus;

	LottoRank(int matchCount, boolean matchBonus, int reward) {
		this.matchCount = matchCount;
		this.isMatchBonus = matchBonus;
		this.reward = reward;
	}

	public static LottoRank findLottoRank(LottoNumbers left, LottoNumbers right) {
		return Arrays
			.stream(LottoRank.values())
			.filter(rank -> rank.isWinning(left.matchedCount(right), left.isMatchBonus(right)))
			.findFirst()
			.get();
	}

	protected abstract boolean isWinning(int matchCount, boolean isMatchBonus);

	protected boolean isSameMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	public int reward() {
		return reward;
	}
}
