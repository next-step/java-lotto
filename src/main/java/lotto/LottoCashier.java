package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCashier {

    private static final String MONEY_VALID_REGEX = "[0-9]+";

    public List<Lotto> pay(String moneyString) {
        validate(moneyString);

        int lottoCount = calculateCountAvailable(Integer.parseInt(moneyString));

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    private void validate(String moneyString) {
        if (moneyString == null || !moneyString.matches(MONEY_VALID_REGEX)) {
            throw new IllegalArgumentException("돈이 아닙니다.");
        }
    }

    private int calculateCountAvailable(int money) {
        return money / LottoShop.LOTTO_PRICE;
    }

}
