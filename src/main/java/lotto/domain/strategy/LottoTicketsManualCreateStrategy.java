package lotto.domain.strategy;

import java.util.List;

public class LottoTicketsManualCreateStrategy implements LottoTicketsCreateStrategy {

    List<List<Integer>> manualNumbers;

    public LottoTicketsManualCreateStrategy(List<List<Integer>> manualNumbers) {
        this.manualNumbers = manualNumbers;
    }

    @Override
    public List<List<Integer>> getLottoNumbers() {
        return manualNumbers;
    }
}
