package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidWinningTicketException;

public class WinningTicket {
    private final LottoTicket lottoTicket;
    private final LottoNumber bonusNumber;

    public WinningTicket(final LottoTicket lottoTicket, final LottoNumber bonusNumber) {
        validate(lottoTicket, bonusNumber);

        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public Rank calculateRank(LottoTicket candidateTicket) {
        System.out.println(candidateTicket.countMatchedNumbers(lottoTicket));
        return Rank.find(
                candidateTicket.countMatchedNumbers(lottoTicket),
                candidateTicket.isContains(bonusNumber)
        );
    }

    private void validate(final LottoTicket lottoTicket, final LottoNumber bonusNumber) {
        if (lottoTicket.isContains(bonusNumber)) {
            throw new InvalidWinningTicketException("보너스 넘버는 당첨티켓 내의 로또 번호와 중복될 수 없습니다.");
        }
    }
}
