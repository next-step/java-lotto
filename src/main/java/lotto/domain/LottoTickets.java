package lotto.domain;

import lotto.common.WinningType;

import java.util.*;

public class LottoTickets {
    private final List<LottoTicket> LOTTO_TICKETS;

    public LottoTickets(int lottoTicketCount) {
        this.LOTTO_TICKETS = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            this.LOTTO_TICKETS.add(new LottoTicket());
        }
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.LOTTO_TICKETS = lottoTickets;
    }

    public String getString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.LOTTO_TICKETS.stream()
                .forEach(l -> stringBuilder.append(l.getString() + "\n"));

        return stringBuilder.toString();
    }

    public long getPrizeSum(LottoTicket winningLottoTicket, int bonusNumber) {
        long prizeSum = 0;
        for (LottoTicket lottoTicket : this.LOTTO_TICKETS) {
            prizeSum += lottoTicket.getWinningType(winningLottoTicket, bonusNumber).getPrize();
        }

        return prizeSum;
    }

    public WinningType[] getWinningTypes(LottoTicket winningLottoTicket, int bonusNumber) {
        WinningType[] winningTypes = new WinningType[this.LOTTO_TICKETS.size()];
        for (int i = 0; i < this.LOTTO_TICKETS.size(); i++) {
            WinningType winningType = this.LOTTO_TICKETS.get(i).getWinningType(winningLottoTicket, bonusNumber);
            winningTypes[i] = winningType;
        }

        return winningTypes;
    }
}
