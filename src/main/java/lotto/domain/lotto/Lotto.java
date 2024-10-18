package lotto.domain.lotto;

import lotto.domain.Prize;
import lotto.domain.lotto.generate.Generate;
import lotto.domain.lotto.ticket.LottoNumber;
import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.lotto.ticket.LottoTickets;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class Lotto {

    private final LottoTickets lottoTickets;
    private final Generate lottoGenerate;


    public Lotto(LottoTickets lottoTickets, Generate lottoGenerate) {
        this.lottoTickets = lottoTickets;
        this.lottoGenerate = lottoGenerate;
    }

    public Map<Prize, Integer> getHitLottoNumbers(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
        return this.lottoTickets.getHitLottoNumbers(winningLottoTicket, bonusNumber);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets.getTickets();
    }


    public LottoTicket getLastWeekWinningNumbers() {
        return lottoGenerate.generate();
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
