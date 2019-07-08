package lotto.domain;

import lotto.domain.generator.AutoLottoNumbersGenerator;
import lotto.domain.generator.LottoNumbersGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoStore {
    private static final LottoNumbersGenerator AUTO_LOTTO_NUMBERS_GENERATOR = new AutoLottoNumbersGenerator();
    private List<LottoTicket> lottoTickets;

    public List<LottoTicket> buyLotto(int money) {
        return buyLotto(AUTO_LOTTO_NUMBERS_GENERATOR, money);
    }

    public List<LottoTicket> buyLotto(LottoNumbersGenerator generator, int money) {
        int canBuyLottoCount = money / 1000;

        lottoTickets = IntStream.rangeClosed(1, canBuyLottoCount)
                .boxed()
                .map(index -> new LottoTicket(generator))
                .collect(Collectors.toList());

        return lottoTickets;
    }

    public LottoResult match(WinningLottoTicket winningLottoTicket) {
        List<LottoRank> ranks = lottoTickets.stream()
                .map(winningLottoTicket::match)
                .collect(Collectors.toList());

        return new LottoResult(ranks);
    }
}
