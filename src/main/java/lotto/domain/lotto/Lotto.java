package lotto.domain.lotto;

import lotto.domain.Prize;
import lotto.domain.lotto.generate.Generate;
import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.lotto.ticket.LottoTickets;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lotto {

    private final LottoTickets lottoTickets;
    private final Generate lottoGenerate;

    public Lotto(LottoTickets lottoTickets, Generate lottoGenerate) {
        this.lottoTickets = lottoTickets;
        this.lottoGenerate = lottoGenerate;
    }

    public Map<Integer, Integer> getHitLottoNumbers(LottoTicket winningLottoTicket) {
        Map<Integer, Integer> map = new HashMap<>();
        lottoTickets.getHitNumbers(winningLottoTicket).forEach(numbers -> {
            Prize prize = Prize.get(numbers);
            map.put(prize.getRank(), map.getOrDefault(prize.getRank(), 0) + prize.getPrice());
        });

        return map;
    }

    public LottoTickets purchaseLotto(int count) {
        for (int i = 0; i < count; i++) {
            LottoTicket ticket = lottoGenerate.generate();
            add(ticket);
        }

        return lottoTickets;
    }

    public LottoTicket getLastWeekWinningNumbers() {
        return lottoGenerate.generate();
    }

    private void add(LottoTicket ticket) {
        lottoTickets.add(ticket);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoTickets, lotto.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
