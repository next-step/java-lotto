package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LottoList {

    private List<Lotto> lottos;

    public LottoList() {
        this.lottos = new ArrayList<>();
    }

    public LottoList(final int lottosCount) {
        if (lottosCount < 1) {
            throw new IllegalArgumentException("1 OR MORE");
        }

        this.lottos = new ArrayList<>(lottosCount);

        for (int i = 0; i < lottosCount; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public LottoList(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return this.lottos.size();
    }

    boolean add(Lotto lotto) {
        return this.lottos.add(lotto);
    }

    int find(Prize prize, WinningLotto winningLotto) {
        int count = 0;

        for (Lotto lotto : this.lottos) {

            count = count(count, prize, winningLotto, lotto);
        }

        return count;
    }

    private int count(int count, Prize targetPrize, WinningLotto winningLotto, Lotto lotto) {
        if (targetPrize == Prize.SECOND) {
            if (winningLotto.countMatch(lotto) == targetPrize.getCountOfMatch()
                    && winningLotto.matchBonus(lotto)) {

                return ++count;
            }

            return count;
        }

        if (targetPrize == Prize.THIRD) {
            if (winningLotto.countMatch(lotto) == targetPrize.getCountOfMatch()
                    && !winningLotto.matchBonus(lotto)) {

                return ++count;
            }

            return count;
        }

        if (winningLotto.countMatch(lotto) == targetPrize.getCountOfMatch()) {
            return ++count;
        }

        return count;
    }

    @Override
    public String toString() {
        return String.valueOf(lottos);
    }

    public void forEach(Consumer<Lotto> printConsumer) {
        lottos.forEach(printConsumer);
    }
}
