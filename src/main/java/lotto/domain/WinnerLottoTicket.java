package lotto.domain;

import java.util.List;

public class WinnerLottoTicket extends AbstractLottoTicket {

    private WinnerLottoTicket(List<Integer> lottoNumber) {
        super(lottoNumber);
    }

    public static WinnerLottoTicket from(List<Integer> args) {
        return new WinnerLottoTicket(args);
    }

}
