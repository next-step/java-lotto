package lotto.result;

interface LottoResultMatcher {
	boolean isMatched(int matchedCount, boolean isBonusBallMatched);
}
