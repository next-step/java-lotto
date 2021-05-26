package lottoauto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(Money money, LottoGenerateStrategy lottoGenerateStrategy) {
        lottoTickets = giveLottoTickets(money, lottoGenerateStrategy);
    }

    public LottoTickets(Money money, List<String> requestedManualLottoNumbers) {
        int totalLottoCount = money.calcLottoCount(LOTTO_TICKET_PRICE);

        if(totalLottoCount < requestedManualLottoNumbers.size()) {
            throw new IllegalArgumentException("돈이 부족하여 수동티켓을 줄 수 없습니다.");
        }

        List<LottoTicket> lottoTickets = new ArrayList<>();

        lottoTickets.addAll(giveManualTickets(requestedManualLottoNumbers));
        lottoTickets.addAll(giveAutoTickets(totalLottoCount - requestedManualLottoNumbers.size()));

        this.lottoTickets = lottoTickets;
    }

    private List<LottoTicket> giveManualTickets(List<String> requestedManualLottoNumbers) {
        List<LottoTicket> result = new ArrayList<>();

        for(int i = 0; i < requestedManualLottoNumbers.size(); i++) {
            LottoGenerateStrategy manualStrategy = new ManualStrategy(requestedManualLottoNumbers.get(i));
            result.add(new LottoTicket(manualStrategy));
        }

        return result;
    }

    private List<LottoTicket> giveAutoTickets(int autoTicketCount) {
        List<LottoTicket> result = new ArrayList<>();

        LottoGenerateStrategy autoStrategy = new AutoStrategy();

        for(int i = 0; i < autoTicketCount; i++) {
            result.add(new LottoTicket(autoStrategy));
        }

        return result;
    }

    private List<LottoTicket> giveLottoTickets(Money money, LottoGenerateStrategy lottoGenerateStrategy) {
        int lottoCount = money.calcLottoCount(LOTTO_TICKET_PRICE);

        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new LottoTicket(lottoGenerateStrategy.generateLottoNumbers()));
        }

        return lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public Money calcInvestment() {
        return new Money(LOTTO_TICKET_PRICE * lottoTickets.size());
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
