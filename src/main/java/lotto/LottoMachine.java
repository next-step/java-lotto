package lotto;

import java.util.EnumMap;

public class LottoMachine {
    private final Lottos lottos;
    private EnumMap<MatchedNumbers, Long> result;

    public LottoMachine(int quantity) {
        this(new Lottos(quantity));
    }

    public LottoMachine(Lottos lottos) {
        this.lottos = lottos;
    }

    public EnumMap<MatchedNumbers, Long> result(LottoNumbers winningNumbers) {
        result = new EnumMap<>(MatchedNumbers.class);

        for (MatchedNumbers matchedNumbers : MatchedNumbers.values()) {
            long matchedLottoCount = lottos.result(winningNumbers, count -> count == matchedNumbers.count());
            result.put(matchedNumbers, matchedLottoCount);
        }

        return result;
    }

    public float profit(int totalCost) {
        int prize = 0;

        for (MatchedNumbers matchedNumbers : result.keySet()) {
            Long matchedLottoCount = result.get(matchedNumbers);
            prize += matchedNumbers.prize(matchedLottoCount);
        }

        return (float) prize / totalCost;
    }

    public Lottos lottos() {
        return this.lottos;
    }
}
