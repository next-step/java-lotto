package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    private static final int DEFAULT_LOTTO_PRICE = 1000;
    private static final int LOTTO_LIMIT_NUMBER = 45;
    private static final int LOTTO_LIMIT_SIZE = 6;

    public Lottos() {}
    public Lottos(final int money) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < purchaseLottoCount(money); i++) {
            lottos.add(new Lotto(createRandomList()));
        }
    }

    static public List<Result> matches(Lotto winningLotto, int bonus, Lottos myLotto) {
        return myLotto.getLottos().stream()
                .map(lotto -> lotto.match(winningLotto, bonus))
                .collect(Collectors.toList());
    }

    private List<Integer> createRandomList() {
        Set<Integer> set = new HashSet<>();
        while (set.size() != LOTTO_LIMIT_SIZE) {
            set.add(getRandom());
        }
        List<Integer> createdLottos = new ArrayList<>(set);
        Collections.sort(createdLottos);
        return createdLottos;
    }

    public int getRandom() {
        return new Random().nextInt(LOTTO_LIMIT_NUMBER) + 1;
    }

    public int purchaseLottoCount(int money) {
        return money / DEFAULT_LOTTO_PRICE;
    }
    public List<Lotto> getLottos() {
        return lottos;
    }
}
