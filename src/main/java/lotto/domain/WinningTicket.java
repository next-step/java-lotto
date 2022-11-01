package lotto.domain;

import java.util.List;

public class WinningTicket {
    private final Ticket ticket;

    private final LottoNumber bonusNumber;

    public WinningTicket(Ticket ticket, int bonusNumber) {
        this(ticket, new LottoNumber(bonusNumber));
    }

    public WinningTicket(Ticket ticket, LottoNumber bonusNumber) {
        validateBonusNumber(ticket.getLottoNumbers(), bonusNumber);
        this.ticket = ticket;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException("보너스 번호를 입력해주세요.");
        }
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 겹치면 안됩니다.");
        }
    }

    public Ticket getTicket() {
        return ticket;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
