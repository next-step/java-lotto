package lotto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class LottoMachine {

    private static final Integer DEFAULT_MATCH_COUNT = 0;
    private static final Money LOTTO_PRICE = new Money(1000);
    private static final LottoNumberMachine LOTTO_NUMBER_MACHINE = new LottoNumberMachine();

    public LottoMachine() {
    }

    public Lottos buyLottos(long inputMoney) {
        Money money = new Money(inputMoney);
        int numberOfLottos = money.countCanBuy(LOTTO_PRICE);

        return createLottos(numberOfLottos);
    }

    private Lottos createLottos(int numberOfLottos) {
        Lottos lottos = new Lottos();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.addNewLotto(LOTTO_NUMBER_MACHINE.lottoNumbers());
        }

        return lottos;
    }

    public Map<Rank, Integer> calculateMatchCount(Lottos lottos, WinnerLotto winLotto) {
        Map<Rank, Integer> matchCounts = lottos.calculateMatchCount(winLotto);
        Map<Rank, Integer> winnerMatchCounts = new HashMap<>();

        for(Rank rank : Rank.LOTTO_WINS) {
            int matchCount = matchCounts.getOrDefault(rank, DEFAULT_MATCH_COUNT);
            winnerMatchCounts.put(rank, matchCount);
        }

        return winnerMatchCounts;
    }

    public BigDecimal calculateProfit(Lottos lottos, WinnerLotto winLotto) {
        return lottos.calculateProfit(winLotto, LOTTO_PRICE);
    }

}
