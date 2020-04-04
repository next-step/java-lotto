package lotto.domain;

import lotto.model.Lotto;

import java.util.*;

public class LottoGame {

    private static final int DEFAULT_LOTTO_PRICE = 1000;


    public List<Lotto> initLottos(int money) {
        int lottoGameCount = purchaseLottoCount(money);
        return createLottos(lottoGameCount);
    }

    public List<Lotto> createLottos(int lottoGameCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoGameCount; i++) {
            lottos.add(new Lotto(createRandomList()));
        }

        return lottos;
    }

    public int getRandom() {
        return new Random().nextInt(45) + 1;
    }

    private List<Integer> createRandomList() {
        Set<Integer> set = new HashSet<>();
        while (set.size() != 6) {
            set.add(getRandom());
        }
        List<Integer> createdLottos = new ArrayList<>(set);
        Collections.sort(createdLottos);
        return createdLottos;
    }

    public int purchaseLottoCount(int money) {
        return money / DEFAULT_LOTTO_PRICE;
    }


    public int match(Lotto winningLotto, Lotto myLotto) {
        int count = safeLongToInt(winningLotto.getNumbers().stream()
                .filter(number -> myLotto.getNumbers().contains(number))
                .count());
        return rank(count);
    }

    public int rank(int num) {
        if (num == 6) {
            return 1;
        } else if (num == 5) {
            return 2;
        } else if (num == 4) {
            return 3;
        } else if (num == 3) {
            return 4;
        } else if (num == 2) {
            return 5;
        }
        return 6;
    }

    private int safeLongToInt(long l) {
        int i = (int) l;
        if ((long) i != l) {
            throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
        }
        return i;
    }

}
