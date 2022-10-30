package lotto.backend.domain;

import java.util.List;

public class WinningLotto {

    private final LottoTicket winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoTicket mainWinningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = mainWinningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> mainWinningNumbers, int bonusNumber) {
        return new WinningLotto(LottoTicket.of(mainWinningNumbers), LottoNumber.of(bonusNumber));
    }

    public LottoRank analysis(LottoTicket lottoTicket) {
        int countOfMatch = lottoTicket.countOfMatch(winningNumbers);
        if (LottoRank.hasBonusNumber(countOfMatch)) {
            boolean isMatched = lottoTicket.hasBonusNumber(bonusNumber);
            return LottoRank.of(new Matching(countOfMatch, isMatched));
        }
        return LottoRank.of(new Matching(countOfMatch, false));
    }
}
