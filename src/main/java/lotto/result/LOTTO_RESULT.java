package lotto.result;

import lotto.number.LottoNumbers;

import java.util.stream.Stream;

public enum LOTTO_RESULT {

	NOTHING("꽝", 0, matchedCount -> matchedCount >= 0 && matchedCount < 3),
	MATCHED_THREE("3개 일치", 5_000, matchedCount -> matchedCount == 3),
	MATCHED_FOUR("4개 일치", 50_000, matchedCount -> matchedCount == 4),
	MATCHED_FIVE("5개 일치", 1_500_000, matchedCount -> matchedCount == 5),
	MATCHED_SIX("6개 일치", 2_000_000_000, matchedCount -> matchedCount == 6);

	LOTTO_RESULT(String description, long amount, LottoResultMatcher lottoResultMatcher) {
		this.description = description;
		this.amount = amount;
		this.lottoResultMatcher = lottoResultMatcher;
	}

	private final String description;
	private final long amount;
	private final LottoResultMatcher lottoResultMatcher;

	public static LOTTO_RESULT findMatchedResult(LottoNumbers tryLottoNumbers, LottoNumbers winningNumbers) {
		int numberMatchedCount = tryLottoNumbers.getMatchedLottoNumbers(winningNumbers).size();
		return Stream.of(LOTTO_RESULT.values())
				.filter(lotto_result -> lotto_result.lottoResultMatcher.isMatched(numberMatchedCount))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("cannot find matched LOTTO_RESULT!"));
	}

	public long getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}
}
