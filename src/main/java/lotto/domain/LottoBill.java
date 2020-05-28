package lotto.domain;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoWinningNumber;
import lotto.domain.vo.LottoDrawResult;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBill {
    private final List<LottoTicket> lottoTickets;

    public LottoBill(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoDrawResult drawLotto(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        int matchCount = (int) lottoWinningNumber.getWinningNumbers().stream()
                .filter(lottoTicket::isContainingLottoNumbers)
                .count();

        boolean matchBonus = lottoTicket.isContainingLottoNumbers(lottoWinningNumber.getBonusNumber());

        return new LottoDrawResult(matchCount, matchBonus);
    }


    public List<LottoDrawResult> drawAllLotto(LottoWinningNumber lottoWinningNumber) {
        return lottoTickets.stream()
                .map(lottoTicket -> drawLotto(lottoTicket, lottoWinningNumber))
                .collect(Collectors.toList());
    }
}
