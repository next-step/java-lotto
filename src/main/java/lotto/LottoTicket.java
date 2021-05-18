package lotto;

import java.util.Set;
import static lotto.LottoConstant.*;

public class LottoTicket {
    private Set<LottoNumber> lottoNumberTicket;

    public LottoTicket(Set<LottoNumber> lottoNumberTicket) {
        if (lottoNumberTicket.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("로또 티켓은 6개의 숫자입니다.");
        }
        this.lottoNumberTicket = lottoNumberTicket;
    }

}
