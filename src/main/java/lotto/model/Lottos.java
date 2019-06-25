package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final static String STRING_ENTER = "\n";
    private List<PickNumbers> lottoNumbers;

    public Lottos(List<PickNumbers> lottos) {
        lottoNumbers = lottos;
    }

    public LottoAggregator matching(WinningNumbers winnerNumbers) {
        LottoAggregator lottoAggregator = new LottoAggregator();
        for (PickNumbers pickNumbers : lottoNumbers) {
            lottoAggregator.put(winnerNumbers.compare(pickNumbers));
        }
        return lottoAggregator;
    }

    public List<PickNumbers> getLottos() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        List<String> lottos = lottoNumbers.stream()
                .map(pickNumbers -> pickNumbers.toString())
                .collect(Collectors.toList());
        return String.join(STRING_ENTER, lottos);
    }
}
