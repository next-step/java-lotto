package lotto;

import lotto.number.LottoNumbers;

import java.util.stream.Stream;

enum LOTTO_RESULT {

	NOTHING(0, matchedCount -> matchedCount >= 0 && matchedCount < 3),
	MATCHED_THREE(5_000, matchedCount -> matchedCount == 3),
	MATCHED_FOUR(50_000, matchedCount -> matchedCount == 4),
	MATCHED_FIVE(1_500_000, matchedCount -> matchedCount == 5),
	MATCHED_SIX(2_000_000_000, matchedCount -> matchedCount == 6);

	LOTTO_RESULT(long amount, LottoResultMatcher lottoResultMatcher) {
		this.amount = amount;
		this.lottoResultMatcher = lottoResultMatcher;
	}

	private long amount;
	private LottoResultMatcher lottoResultMatcher;

	public static LOTTO_RESULT findMatchedResult(LottoNumbers tryLottoNumbers, LottoNumbers winningNumbers) {
		int numberMatchedCount = tryLottoNumbers.getMatchedLottoNumbers(winningNumbers).size();
		return Stream.of(LOTTO_RESULT.values())
				.filter(lotto_result -> lotto_result.lottoResultMatcher.isMatched(numberMatchedCount))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("cannot find matched LOTTO_RESULT!"));
	}
}
