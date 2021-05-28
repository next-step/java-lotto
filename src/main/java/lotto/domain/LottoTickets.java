package lotto.domain;

import lotto.common.WinningType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<WinningType> getWinningResult(LottoTicket winningLottoTicket, int bonusNumber) {
        return this.lottoTickets.stream()
                .map(t -> t.getWinningType(winningLottoTicket, bonusNumber))
                .collect(Collectors.toList());
    }

    public LottoTickets addAll(List<LottoTicket> inputTickets) {
        this.lottoTickets.addAll(inputTickets);
        return new LottoTickets(this.lottoTickets);
    }
}
