package lotto.domain.strategy;

import java.util.List;

import lotto.domain.LottoTicket;
import lotto.domain.util.StringSplitter;

public class ManualLottoGenerator implements LottoGenerator {
    private final List<String> manualLottos;

    public ManualLottoGenerator(List<String> manualLottos) {
        this.manualLottos = manualLottos;
    }

    @Override
    public List<LottoTicket> generate() {
        return StringSplitter.bulkConvertStrToLottoNumSet(manualLottos);
    }
}
