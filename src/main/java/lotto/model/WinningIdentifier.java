package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class WinningIdentifier {

    private static final String DUPLICATED_BONUS_NUMBER_MSG = "이미 당첨 번호에 해당하는 번호입니다.";
    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public WinningIdentifier(LottoTicket winningTicket, LottoNumber bonusNumber) {
        validateDuplicate(winningTicket, bonusNumber);
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(LottoTicket winningTicket, LottoNumber bonusNumber) {
        if(winningTicket.contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_MSG);
        }
    }

    public Rank checkWinning(LottoTicket lottoTicket) {
        return Rank.of(lottoTicket.compareTicket(winningTicket), lottoTicket.contains(bonusNumber));
    }

    public WinningReport checkTicketsWinning(List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
                .map(ticket -> Rank.of(ticket.compareTicket(winningTicket), ticket.contains(bonusNumber)))
                .collect(collectingAndThen(toList(), WinningReport::new));
    }
}
