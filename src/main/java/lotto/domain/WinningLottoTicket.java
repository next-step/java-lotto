package lotto.domain;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-07-08
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class WinningLottoTicket {
    private LottoTicket winningLottoTicket;
    private LottoNumber bonusNumber;

    public WinningLottoTicket(List<Integer> numbers, int bonusNumber) {
        this(new LottoTicket(numbers), bonusNumber);
    }

    public WinningLottoTicket(LottoTicket lottoTicket, int bonusNumber) {
        this.winningLottoTicket = lottoTicket;
        this.bonusNumber = new LottoNumber(bonusNumber);

        if (lottoTicket.contains(this.bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public LottoRank match(LottoTicket lottoTicket) {
        int matchCount = winningLottoTicket.match(lottoTicket);
        boolean matchBonus = lottoTicket.contains(bonusNumber);

        return LottoRank.of(matchCount, matchBonus);
    }
}
