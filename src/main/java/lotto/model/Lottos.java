package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final static String STRING_ENTER = "\n";
    private List<LottoNumbers> pickNumbers;

    public Lottos() {
        this.pickNumbers = new ArrayList<>();
    }

    public Lottos add(LottoNumbers newPick) {
        this.pickNumbers.add(newPick);
        return this;
    }

    public LottoAggregator matchWinningNumber(WinningNumbers winnerNumbers) {
        LottoAggregator lottoAggregator = new LottoAggregator();
        for (LottoNumbers pickNumbers : pickNumbers) {
            lottoAggregator.put(winnerNumbers.match(pickNumbers));
        }
        return lottoAggregator;
    }

    public List<LottoNumbers> getPickNumbers() {
        return pickNumbers;
    }

    int size() {
        return pickNumbers.size();
    }

}
