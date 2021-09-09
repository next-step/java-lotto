package step5.domain.lottoticket;

import step5.domain.LottoNumber;

import java.util.List;

public interface LottoTicket {
    List<LottoNumber> ticket();

    Long matchWinningLotto(WinningLottoTicket winningLottoTicket);

    boolean matchBonusBall(WinningLottoTicket winningLottoTicket);
}
