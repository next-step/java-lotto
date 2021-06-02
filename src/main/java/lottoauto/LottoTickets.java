package lottoauto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private static final int FIRST_INDEX = 0;
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int count, LottoGenerateStrategy lottoGenerateStrategy) {
        lottoTickets = giveLottoTickets(count, lottoGenerateStrategy);
    }

    public void addFirst(List<LottoTicket> lottoTickets) {
        this.lottoTickets.addAll(FIRST_INDEX, lottoTickets);
    }

    private List<LottoTicket> giveLottoTickets(int count, LottoGenerateStrategy lottoGenerateStrategy) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoTickets.add(new LottoTicket(lottoGenerateStrategy.generateLottoNumbers()));
        }

        return lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public Money calcInvestment() {
        return new Money(LottoTicket.LOTTO_TICKET_PRICE * lottoTickets.size());
    }

    public void checkHitCount(WinningNumbersWithBonus winningNumbersWithBonus, LottoStatement lottoStatement) {
        for (LottoTicket lottoTicket: lottoTickets) {
            lottoTicket.calcHitCount(winningNumbersWithBonus);
            lottoStatement.judge(lottoTicket.hitCount(), lottoTicket.isMatchedBonus());
        }
    }

    public double calcProceedsRate(LottoStatement lottoStatement) {
        Money investment = calcInvestment();
        Money proceeds = lottoStatement.calcProceeds();

        return investment.calcProceedsRate(proceeds);
    }

    @Override
    public String toString() {
        String result = "";
        for (LottoTicket lottoTicket: lottoTickets) {
            result += lottoTicket.toString() + "\n";
        }

        return result;
    }
}
