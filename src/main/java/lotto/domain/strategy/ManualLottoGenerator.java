package lotto.domain.strategy;

import java.util.List;

import lotto.domain.LottoTicket;

public class ManualLottoGenerator implements LottoGenerator {
    private List<LottoTicket> numbers;

    @Override
    public List<LottoTicket> generate(int quantity) {
        return numbers;
    }
}
