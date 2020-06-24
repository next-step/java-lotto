package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final LottoTicket winningTicket;
    private final int bonusNumber;

    public WinningLotto(LottoTicket winningTicket, int bonusNumber) {
        if (!isValid(winningTicket, bonusNumber)) {
            throw new IllegalArgumentException();
        }
        this.bonusNumber = bonusNumber;
        this.winningTicket = winningTicket;
    }

    public List<Rank> getLottoRank(final List<LottoTicket> buyingLottoTickets) {
        return buyingLottoTickets.stream()
                .map((buyingLottoTicket -> buyingLottoTicket.getRankBy(winningTicket, bonusNumber)))
                .collect(Collectors.toList());
    }

    private boolean isValid(final LottoTicket lottoTicket, final int bonusNumber) {
        return !lottoTicket.hasNumber(bonusNumber);
    }

}
