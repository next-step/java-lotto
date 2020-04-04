package lotto.domain;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {

    private static final int DEFAULT_LOTTO_PRICE = 1000;
    private static final int LOTTO_LIMIT_NUMBER = 45;
    private static final int LOTTO_LIMIT_SIZE = 6;


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
        return new Random().nextInt(LOTTO_LIMIT_NUMBER) + 1;
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

    public int purchaseLottoCount(int money) {
        return money / DEFAULT_LOTTO_PRICE;
    }


    public List<Rank> matches(Lotto winningLotto, List<Lotto> myLottos) {
        return myLottos.stream()
                .map(myLotto -> match(winningLotto, myLotto))
                .collect(Collectors.toList());
    }

    public Rank match(Lotto winningLotto, Lotto myLotto) {
        int count = safeLongToInt(winningLotto.getNumbers().stream()
                .filter(number -> myLotto.getNumbers().contains(number))
                .count());

        return new Rank(Rank.calc(count));
    }


    private int safeLongToInt(long l) {
        int i = (int) l;
        if ((long) i != l) {
            throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
        }
        return i;
    }

}
