package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.util.StringUtil.split;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private final Lotties lotties;
    private final int lottoCount;

    public LottoMachine(final int money) {
        if (!validMoney(money)) {
            throw new RuntimeException();
        }
        this.lottoCount = money / LOTTO_PRICE;
        this.lotties = new Lotties(createRandomLotties(money));
    }

    private List<Lotto> createRandomLotties(final int money) {
        List<Lotto> lotties = new ArrayList<>();
        for(int i = 0; i < money / LOTTO_PRICE; i++) {
            lotties.add(new Lotto(new RandomNumGenerator()));
        }
        return lotties;
    }

    private boolean validMoney(int money) {
        return money % LOTTO_PRICE == 0;
    }

    public Lotties getLotties() {
        return lotties;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int lottiesCount() {
        return lotties.getLottiesSize();
    }

    public void confirmLotto(String winningNumber) {
        lotties.sameNumberCount(Arrays.stream(split(winningNumber))
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList()));
    }
}
