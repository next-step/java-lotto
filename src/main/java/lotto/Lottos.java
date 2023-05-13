package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public long getLottoCount() {
        return lottos.size();
    }

    public List<String> getLottosString() {
        List<String> strs = new ArrayList<>();

        for (Lotto lotto : lottos) {
            strs.add(lotto.getNumbersString());
        }
        return strs;
    }

}
