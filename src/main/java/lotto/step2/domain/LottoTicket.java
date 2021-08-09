package lotto.step2.domain;

import java.util.List;

public class LottoTicket {

    private final List<Integer> lottoNumber;

    public LottoTicket() {
        this.lottoNumber = LottoMachine.mixLottoNumbers();
    }
}
