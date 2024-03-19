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

    public Map<AmountEnum, Integer> findWinner(final Lotto winLotto) {
        Map<AmountEnum, Integer> hashMap = new HashMap<>();
        hashMap.put(AmountEnum.OTHER, 0);
        hashMap.put(AmountEnum.FOURTH, 0);
        hashMap.put(AmountEnum.THIRD, 0);
        hashMap.put(AmountEnum.SECOND, 0);
        hashMap.put(AmountEnum.FIRST, 0);
        for (int i = 0; i < lottos.size(); i++) {
            AmountEnum amountEnum = lottos.get(i).getAmountEnumCompareWinNumber(winLotto);
            hashMap.put(amountEnum, hashMap.get(amountEnum) + 1);
        }
        return hashMap;
    }
}
