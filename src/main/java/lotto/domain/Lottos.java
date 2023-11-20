package lotto.domain;

import lotto.domain.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lottos {

    private List<Lotto> value;

    public Lottos(int lottoCount) {
        value = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            value.add(new Lotto());
        }
    }

    public String findLottos() {
        StringBuilder sc = new StringBuilder();
        for (int i = 0; i < value.size(); i++) {
            sc.append(value.get(i).findLotto());
            sc.append(System.lineSeparator());
        }
        return sc.toString();
    }

    public List<Lotto> getValue() {
        return value;
    }
}
