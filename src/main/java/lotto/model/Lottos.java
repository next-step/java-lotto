package lotto.model;

import java.util.*;

public class Lottos {
    private List<Lotto> lottos;

    private static final int DEFAULT_LOTTO_PRICE = 1000;
    private static final int LOTTO_LIMIT_NUMBER = 45;
    private static final int LOTTO_LIMIT_SIZE = 6;

    public Lottos() {}
    public Lottos(final int lottoGameCount) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottoGameCount; i++) {
            lottos.add(new Lotto(createRandomList()));
        }
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

    public List<Lotto> getLottos() {
        return lottos;
    }
}
