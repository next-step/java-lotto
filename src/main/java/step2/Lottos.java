package step2;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final int INITIAL_WINNER_COUNT = 0;
    private static final int MONEY_MIN = 0;
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(int money) {
        validatePositive(money);
        lottos = new ArrayList<>();
        purchaseLottos(money);
    }

    private void validatePositive(int money) {
        if (money < MONEY_MIN) {
            throw new IllegalArgumentException("돈이 음수일 수 없습니다");
        }
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

    public int getWinnerCount(int matchCount, Lotto winner) {
        int winnerCount = INITIAL_WINNER_COUNT;

        for (Lotto lotto : lottos) {
            winnerCount = (matchCount == lotto.getMatchCount(winner)) ? winnerCount + 1 : winnerCount;
        }
        return winnerCount;
    }
}
