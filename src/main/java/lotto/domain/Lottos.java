package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }

    public WinningResult checkLottosPrize(WinningNumber winningNumber) {
        Integer[] prizeNums = new Integer[Prize.values().length];
        Arrays.fill(prizeNums, 0);

        for (Lotto lotto : lottos) {
            Prize prize = winningNumber.checkLottoPrize(lotto);
            prizeNums[prize.ordinal()]++;
        }

        return new WinningResult(Arrays.asList(prizeNums));
    }

    public Lottos add(Lottos lottosToAdd) {
        return lottosToAdd.add(lottos);
    }

    private Lottos add(List<Lotto> lottoListToAdd) {
        List<Lotto> lottoList = new ArrayList(lottos);
        lottoList.addAll(lottoListToAdd);

        return new Lottos(lottoList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

}
