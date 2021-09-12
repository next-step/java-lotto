package lotto;

import java.util.Arrays;

public enum LottoRank {
	FIRST(6, false, new Money(2_000_000_000)) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return this.isSameMatchCount(matchCount);
		}
	},

	SECOND(5, true, new Money(30_000_000)) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return this.isSameMatchCount(matchCount) && this.isMatchBonus == isMatchBonus;
		}
	},

	THIRD(5, false, new Money(1_500_000)) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return this.isSameMatchCount(matchCount) && this.isMatchBonus == isMatchBonus;
		}
	},

	FOURTH(4, false, new Money(50_000)) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return this.isSameMatchCount(matchCount);
		}
	},

	FIFTH(3, false, new Money(5_000)) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return this.isSameMatchCount(matchCount);
		}
	},

	NOTHING(2, false, new Money(0)) {
		@Override
		protected boolean isWinning(int matchCount, boolean isMatchBonus) {
			return matchCount <= this.matchCount;
		}
	};

	private final Money reward;
	protected final int matchCount;
	protected final boolean isMatchBonus;

	LottoRank(int matchCount, boolean matchBonus, Money reward) {
		this.matchCount = matchCount;
		this.isMatchBonus = matchBonus;
		this.reward = reward;
	}

	public static LottoRank findLottoRank(int matchedCount, boolean isMachBonus) {
		return Arrays
			.stream(LottoRank.values())
			.filter(rank -> rank.isWinning(matchedCount, isMachBonus))
			.findFirst()
			.get();
	}

	protected abstract boolean isWinning(int matchCount, boolean isMatchBonus);

	protected boolean isSameMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	public Money reward() {
		return reward;
	}
}
