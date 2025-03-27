package lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;

    private int count;
    private Lottos lottos;
    Map<Division, Integer> winnerCountMap;

    public LottoGame(int money) {
        validateMoney(money);
        count = money / LOTTO_PRICE;
        lottos = new Lottos(count);
    }

    public LottoGame(Lottos lottos) {
        count = lottos.size();
        this.lottos = lottos;
    }

    private void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또 구입 금액은 " + LOTTO_PRICE + "원을 넘어야 합니다.");
        }
    }

    public void draw(List<Integer> numbers) {
        winnerCountMap = lottos.compareNumbers(Lotto.createManually(numbers));
    }

    public double calculateEarningRate() {
        int earning = 0;
        for (Map.Entry<Division, Integer> entry: winnerCountMap.entrySet()) {
           earning += entry.getKey().getPrize() * entry.getValue();
        }
        return (double)earning / (count * LOTTO_PRICE);
    }

    public List<List<Integer>> getLottos() {
        return lottos.getLottos();
    }

    public Map<Division, Integer> getWinnerCountMap() {
        return winnerCountMap;
    }
}
