package lotto;

import java.util.List;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;

    private int count;
    private Lotto winningLotto;

    public LottoGame(int money) {
        validateMoney(money);
        count = money / LOTTO_PRICE;
    }

    private void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또 구입 금액은 " + LOTTO_PRICE + "원을 넘어야 합니다.");
        }
    }

    public void draw(List<Integer> numbers) {
        winningLotto = new Lotto(numbers);
    }
}
