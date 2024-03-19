package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

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

    public Map<AmountEnum, Long> findWinner(final Lotto winLotto) {
        return lottos.stream()
                .collect(Collectors.groupingBy(
                        lotto -> lotto.getAmountEnumCompareWinNumber(winLotto)
                        , counting()));
    }
}
