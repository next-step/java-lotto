package study.step2.domain;

import java.util.List;

public class LottoTicket {
    private final List<Integer> ticket;

    LottoTicket(List<Integer> ticket){
        this.ticket = ticket;
    }

    public List<Integer> getTicket(){
        return ticket;
    }

    public LottoRank rank(LottoWinningNumber winnerNumber) {
        return LottoRank.findLottoRank(this, winnerNumber);
    }
}
