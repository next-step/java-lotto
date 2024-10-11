package lotto.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_UNIT_PRICE = 1000;
    private final PrizeMonies prizeMonies;

    public LottoMachine() {
        this.prizeMonies = new PrizeMonies();
    }

    public List<Lotto> insert(int money) {
        int count = getLottoCount(money);
        return issue(count);
    }

    private int getLottoCount(int money) {
        return money / LOTTO_UNIT_PRICE;
    }

    private List<Lotto> issue(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(create());
        }

        return lottos;
    }

    private Lotto create() {
        List<Integer> initNumbers = init();
        Collections.shuffle(initNumbers);
        return new Lotto(initNumbers.subList(0, 6));
    }

    private List<Integer> init() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public List<WinnerLotto> winnerLottos(List<Lotto> lottos, List<Integer> winnersNumber) {
        List<WinnerLotto> resultLottos = new ArrayList<>();

        for (Lotto lotto : lottos) {
            PrizeMoney prizeMoney = prizeMonies.result(lotto.matchCount(winnersNumber));
            resultLottos.add(new WinnerLotto(prizeMoney, lotto));
        }

        return resultLottos.stream().filter(l -> l.isWinner()).collect(Collectors.toList());
    }
}
