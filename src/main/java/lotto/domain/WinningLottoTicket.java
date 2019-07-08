package lotto.domain;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-07-08
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class WinningLottoTicket {
    private LottoTicket winningLottoTicket;

    public WinningLottoTicket(List<Integer> numbers) {
        this.winningLottoTicket = new LottoTicket(numbers);
    }

    public LottoRank match(LottoTicket lottoTicket) {
        return LottoRank.of(winningLottoTicket.match(lottoTicket));
    }
}
