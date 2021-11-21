package lotto.domain;

import java.util.List;

public class LottoTicket extends AbstractLottoTicket {

    public LottoTicket(List<Integer> lottoNumber) {
        super(lottoNumber);
    }

    public static LottoTicket from(List<Integer> args) {
        return new LottoTicket(args);
    }
}
