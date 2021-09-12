package lotto;

public interface LottoReport {
	int lottoMatchCount(int matchedNumberCount, boolean isMatchBonus);

	double profit();
}
