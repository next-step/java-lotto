package dev.dahye.lotto.domain;

import java.util.Objects;

public class Winning {
    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    private Winning(LottoTicket winningTicket, LottoNumber bonusNumber) {
        Objects.requireNonNull(winningTicket, "winningTicket must not be null");
        Objects.requireNonNull(bonusNumber, "bonusNumber must not be null");

        validateContainsWinningTicket(winningTicket, bonusNumber);
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public static Winning of(LottoTicket winningTicket, LottoNumber bonusNumber) {
        return new Winning(winningTicket, bonusNumber);
    }

    private static void validateContainsWinningTicket(LottoTicket winningTicket, LottoNumber bonusNumber) {
        if (winningTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Rank ranking(LottoTicket lottoTicket) {
        int matchCount = this.winningTicket.getCountOfMatch(lottoTicket);
        boolean isMatchBonusNumber = lottoTicket.contains(bonusNumber);

        return Rank.valueOf(matchCount, isMatchBonusNumber);
    }
}
