package domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BuyLotto {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;
    private final int money;
    private final Lottos lottos;

    public BuyLotto(int money) {
        this.money = money;
        this.lottos = new Lottos(new LottoGenerator(START_NUMBER, END_NUMBER), buyLottoCount());
    }

    public int buyLottoCount() {
        return this.money / LOTTO_PRICE;
    }

    public String buyLottoList() {
        return lottos.toString();
    }

    public LottoStatistics winningStatistics(String winningNumbers) {
        return new LottoStatistics(lottos, new Lotto(Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList())));
    }

}
