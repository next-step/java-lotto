package lotto.domain;

import java.util.ArrayList;
import java.util.List;

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
}
