package lotto;

import java.util.List;

public class WinningResult {
    private final LottoTicket winningTicket;
    private final int bonusNumber;

    public WinningResult(LottoTicket winningTicket, int bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        List<Integer> winningNumbers = this.winningTicket.getLottoNumbers();
        if (winningNumbers.contains(this.bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }

        if (this.bonusNumber < LottoTicket.LOTTO_MIN || this.bonusNumber > LottoTicket.LOTTO_MAX) {
            throw new IllegalArgumentException("보너스 볼은 1부터 45 사이여야 합니다.");
        }
    }

    public Rank calculateRank(LottoTicket lottoTicket) {
        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();
        long matchCount = getMatchCount(lottoNumbers);
        boolean matchBonus = isMatchBonusNumber(lottoNumbers);

        return Rank.valueOf(matchCount, matchBonus);
    }

    public long getMatchCount(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .filter(this.winningTicket.getLottoNumbers()::contains)
                .count();
    }

    public boolean isMatchBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(this.bonusNumber);
    }
}
