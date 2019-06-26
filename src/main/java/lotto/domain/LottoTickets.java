package lotto.domain;

import lotto.domain.generator.LottoNumbersGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(LottoNumbersGenerator generator, int count) {
        lottoTickets = IntStream.rangeClosed(1, count)
                .boxed()
                .map(index -> new LottoTicket(generator))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoResult match(WinningNumbers winningNumbers) {
        List<LottoRank> lottoRanks = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.match(winningNumbers))
                .collect(Collectors.toList());
        return new LottoResult(lottoRanks);
    }
}
