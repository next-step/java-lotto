package step2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private static final int INITIAL_WINNER_COUNT = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int WINNER_MATCH_COUNT_MIN = 3;
    private static final int WINNER_MATCH_COUNT_MAX = 6;

    private final List<Lotto> lottos;

    public Lottos(int money) {
        lottos = new ArrayList<>();
        purchaseLottos(money);
    }

    private void purchaseLottos(int money) {
        while (money >= LOTTO_PRICE) {
            lottos.add(new Lotto());
            money -= LOTTO_PRICE;
        }
    }

    //테스팅을 위한 protected 생성자
    protected Lottos(List<Integer>... lottoNumbersList) {
        lottos = new ArrayList<>();
        for (List<Integer> lottoNumbers : lottoNumbersList) {
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public double getYield(Lotto winner) {
        Map<Integer, Integer> winners = getWinners(winner);
        return (double) LottoWinnings.getYield(winners) / (LOTTO_PRICE * lottos.size());
    }

    public Map<Integer, Integer> getWinners(Lotto winner) {
        Map<Integer, Integer> winners = new HashMap<>();

        for (int matchCount = WINNER_MATCH_COUNT_MIN; matchCount <= WINNER_MATCH_COUNT_MAX; matchCount++) {
            winners.put(matchCount, getWinnerCount(matchCount, winner));
        }
        return winners;
    }

    private int getWinnerCount(int matchCount, Lotto winner) {
        return (int) lottos.stream()
            .filter(lotto -> lotto.getMatchCount(winner) == matchCount)
            .count();
    }
}
