package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLottos {
    private final static int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public MyLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static MyLottos rollLottos(int amount) {
        List<Lotto> array = new ArrayList<>();

        int count = getCount(amount);

        for (int i = 0; i < count; i++) {
            array.add(new Lotto());
        }

        return new MyLottos(array);
    }

    private static int getCount(final int amount) {
        int count = amount / LOTTO_PRICE;
        return count;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public Integer getLottoCount() {
        return lottos.size();
    }

    public Map findWinner(final String winNumber) {
        Lotto winLotto = new Lotto(winNumber);
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        hashMap.put(3, 0);
        hashMap.put(4, 0);
        hashMap.put(5, 0);
        hashMap.put(6, 0);
        for (int i = 0; i < lottos.size(); i++) {
            AmountEnum amountEnum = lottos.get(i).compareWinNumber(winLotto);
            hashMap.put(amountEnum.getCollectedCount(), hashMap.get(amountEnum.getCollectedCount()) + 1);
        }
        return hashMap;
    }
}
