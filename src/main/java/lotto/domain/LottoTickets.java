package lotto.domain;

import lotto.common.WinningType;

import java.util.*;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int lottoTicketCount) {
        this.lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            this.lottoTickets.add(new LottoTicket());
        }
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public String getString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(LottoTicket lottoTicket : this.lottoTickets) {
            stringBuilder.append(lottoTicket.getString() + "\n");
        }

        return stringBuilder.toString();
    }

    public long getPrizeSum(LottoTicket winningLottoTicket, int bonusNumber) {
        long prizeSum = 0;
        for (LottoTicket lottoTicket : this.lottoTickets) {
            prizeSum += lottoTicket.getWinningType(winningLottoTicket, bonusNumber).getPrize();
        }

        return prizeSum;
    }

    public WinningType[] getWinningTypes(LottoTicket winningLottoTicket, int bonusNumber) {
        WinningType[] winningTypes = new WinningType[this.lottoTickets.size()];
        for (int i = 0; i < this.lottoTickets.size(); i++) {
            WinningType winningType = this.lottoTickets.get(i).getWinningType(winningLottoTicket, bonusNumber);
            winningTypes[i] = winningType;
        }

        return winningTypes;
    }
}
