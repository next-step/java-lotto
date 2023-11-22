package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> value;

    public Lottos(int lottoCount) {
        value = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            value.add(new Lotto());
        }
    }

//    public Lottos(List<Lotto> value) {
//        this.value = value;
//    }

    public Lottos(List<String> value) {
        this.value = new ArrayList<>();
        for (String lotto : value) {
            this.value.add(new Lotto(lotto));
        }
    }

    public Lottos(Lottos manualLottos, Lottos autoLottos) {
        value = new ArrayList<>();
        value.addAll(manualLottos.value);
        value.addAll(autoLottos.value);
    }

    public String findLottos() {
        StringBuilder sc = new StringBuilder();
        for (Lotto lotto : value) {
            sc.append(lotto.findLotto());
            sc.append(System.lineSeparator());
        }
        return sc.toString();
    }

    public List<Lotto> getValue() {
        return value;
    }
}
