package lotto.domain;

import java.util.List;

public class ManualLottoTicketGenerator implements LottoTicketGenerator {
    private final List<Integer> lottoNumberList;

    public ManualLottoTicketGenerator(List<Integer> lottoNumberList){
        this.lottoNumberList = lottoNumberList;
    }

    @Override
    public LottoTicket execute() {
        return LottoTicket.of(lottoNumberList);
    }
}
