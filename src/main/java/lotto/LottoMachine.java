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
            lottos.addNewLotto(LOTTO_NUMBER_MACHINE.lottoNumbers()); // 어떻게 테스트를 할 수 있을까 ..
        }

        return lottos;
    }

    public Map<Integer, Integer> calculateMatchCount(Lottos lottos, Lotto winLotto) {
        Map<Integer, Integer> matchCounts = lottos.calculateMatchCount(winLotto);
        Map<Integer, Integer> winnerMatchCounts = new HashMap<>();

        for (LottoWin lottoWin : LottoWin.LOTTO_WINS) {
            int expectedMatchCount = lottoWin.numberOfMatch();
            int matchCount = matchCounts.getOrDefault(expectedMatchCount, DEFAULT_MATCH_COUNT);
            winnerMatchCounts.put(expectedMatchCount, matchCount);
        }

        return winnerMatchCounts;
    }

    public BigDecimal calculateProfit(Lottos lottos, Lotto winLotto) {
        return lottos.calculateProfit(winLotto, LOTTO_PRICE);
    }

}
