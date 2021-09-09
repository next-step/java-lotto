package step5.domain.lottoticket;

import step5.domain.LottoNumber;

import java.util.List;

public interface LottoTicket {
    public List<LottoNumber> ticket();

    public Long matchWinningLotto(WinningLottoTicket winningLottoTicket);

    public boolean matchBonusBall(WinningLottoTicket winningLottoTicket);
}
