package lotto;

import java.util.*;

public class Lottos {
    private static final int PRICE = 1000;

    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(int count) {
        this.lottos = new ArrayList<>();
        generateLottos(count);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private void generateLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public void calculateAllMatchCount(List<Integer> winningLotto) {
        for (Lotto lotto : lottos) {
            lotto.calculateMatchCount(winningLotto);
        }
    }

    public static int countByAmount(int paidAmount) {
        if (paidAmount < PRICE) {
            throw new IllegalArgumentException("지불한 금액이 로또 금액보다 적습니다.");
        }
        return paidAmount / PRICE;
    }

}
