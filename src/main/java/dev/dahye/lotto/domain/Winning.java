package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.LottoNumber;

public class Winning {
    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    private Winning(LottoTicket winningTicket, LottoNumber bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public static Winning of(LottoTicket winningTicket, LottoNumber bonusNumber) {
        validateContainsWinningTicket(winningTicket, bonusNumber);
        return new Winning(winningTicket, bonusNumber);
    }

    private static void validateContainsWinningTicket(LottoTicket winningTicket, LottoNumber bonusNumber) {
        if (winningTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Rank ranking(LottoTicket lottoTicket) {
        int matchCount = this.getCountOfMatch(lottoTicket);
        boolean isMatchBonusNumber = lottoTicket.contains(bonusNumber);

        return Rank.valueOf(matchCount, isMatchBonusNumber);
    }

    public int getCountOfMatch(LottoTicket lottoTicket) {
        return this.winningTicket.getCountOfMatch(lottoTicket);
    }
}
