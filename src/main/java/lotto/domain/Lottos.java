package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public int calculateNumberOfLottosAutomatical(int numberOfLottoManual, Money money) {
        return money.calculateLotto() - numberOfLottoManual;
    }
}
