package lotto;

import java.util.List;
import java.util.Map;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;

    private int count;
    private Lotto winningLotto;
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
        winningLotto = new Lotto(numbers);
    }

    public final Map<Division, Integer> lottoWinning() {
        winnerCountMap = lottos.compareNumbers(winningLotto);
        return winnerCountMap;
    }

    public double calculateEarningRate() {
        int earning = 0;
        for (Map.Entry<Division, Integer> entry: winnerCountMap.entrySet()) {
           earning += entry.getKey().getPrize() * entry.getValue();
        }
        System.out.println((double)earning / (count * LOTTO_PRICE));
        return (double)earning / (count * LOTTO_PRICE);
    }
}
