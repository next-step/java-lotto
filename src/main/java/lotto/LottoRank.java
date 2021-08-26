package lotto;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
	FIRST(6, 2000000000) {
		@Override
		protected boolean isWinning(int matchCount) {
			return this.isSameMatchCount(matchCount);
		}
	},

	SECOND(5, 1500000) {
		@Override
		protected boolean isWinning(int matchCount) {
			return this.isSameMatchCount(matchCount);
		}
	},

	THIRD(4, 50000) {
		@Override
		protected boolean isWinning(int matchCount) {
			return this.isSameMatchCount(matchCount);
		}
	},

	FOURTH(3, 5000) {
		@Override
		protected boolean isWinning(int matchCount) {
			return this.isSameMatchCount(matchCount);
		}
	},

	NOTHING(2, 0) {
		@Override
		protected boolean isWinning(int matchCount) {
			return matchCount <= this.matchCount;
		}
	};

	private final int reward;
	protected final int matchCount;

	LottoRank(int matchCount, int reward) {
		this.matchCount = matchCount;
		this.reward = reward;
	}

	public static LottoRank findLottoRank(LottoNumbers left, LottoNumbers right) {
		return Arrays
			.stream(LottoRank.values())
			.filter(rank -> rank.isWinning(left.matchedCount(right)))
			.findFirst()
			.get();
	}

	protected abstract boolean isWinning(int matchCount);

	protected boolean isSameMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	public int reward() {
		return reward;
	}
}
