package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningNumber;
import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottoNumbers() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoWinningResult getWinningResult(LottoWinningNumber winningNumber) {
        return this.lottos
                .stream()
                .map(lotto -> lotto.getAwardResult(winningNumber))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        LottoWinningResult::new));
    }
}
