package lotto.result;

import java.util.Arrays;

public enum LottoResult {

	NOTHING("꽝", 0, (matchedCount, isBonusBallMatched) -> matchedCount >= 0 && matchedCount < 3),
	MATCHED_THREE("3개 일치", 5_000, (matchedCount, isBonusBallMatched) -> matchedCount == 3),
	MATCHED_FOUR("4개 일치", 50_000, (matchedCount, isBonusBallMatched) -> matchedCount == 4),
	MATCHED_FIVE("5개 일치", 1_500_000,
			(matchedCount, isBonusBallMatched) -> matchedCount == 5 && !isBonusBallMatched),
	MATCHED_FIVE_WITH_BONUS("5개 일치(보너스 볼 일치)", 30_000_000,
			(matchedCount, isBonusBallMatched) -> matchedCount == 5 && isBonusBallMatched),
	MATCHED_SIX("6개 일치", 2_000_000_000, (matchedCount, isBonusBallMatched) -> matchedCount == 6);

	LottoResult(String description, long amount, LottoResultMatcher lottoResultMatcher) {
		this.description = description;
		this.amount = amount;
		this.lottoResultMatcher = lottoResultMatcher;
	}

	private final String description;
	private final long amount;
	private final LottoResultMatcher lottoResultMatcher;

	public static LottoResult findMatchedResult(int numberMatchedCount, boolean isBonusBallMatched) {
		return Arrays.stream(LottoResult.values())
				.filter(lotto_result -> lotto_result.lottoResultMatcher
						.isMatched(numberMatchedCount, isBonusBallMatched))
				.findFirst()
				.orElse(NOTHING);
	}

	public long getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}
}
