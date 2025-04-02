package lotto;

import java.util.List;

public class WinningResult {
    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public WinningResult(LottoTicket winningTicket, LottoNumber bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        if (winningTicket.contains(this.bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Rank calculateRank(LottoTicket lottoTicket) {
        long matchCount = getMatchCount(lottoTicket);
        boolean matchBonus = isMatchBonusNumber(lottoTicket);

        return Rank.valueOf(matchCount, matchBonus);
    }

    private long getMatchCount(LottoTicket lottoTicket) {
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();

        return lottoNumbers.stream()
                .filter(this.winningTicket::contains)
                .count();
    }

    private boolean isMatchBonusNumber(LottoTicket lottoTicket) {
        return lottoTicket.contains(this.bonusNumber);
    }
}
