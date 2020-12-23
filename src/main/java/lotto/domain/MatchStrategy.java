package lotto.domain;

public interface MatchStrategy {
	boolean isMatch(LottoLottery lottoLottery, WinLottoNumbers winLottoNumbers);
}
