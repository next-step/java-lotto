package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Lottos {
    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int size() {
        return this.lottoList.size();
    }

    public void forEach(Consumer<Lotto> action) {
        Objects.requireNonNull(action);
        for (Lotto lotto : this.getLottoList()) {
            action.accept(lotto);
        }
    }

    public static Lottos of(List<Lotto>... lottos) {
        if (lottos == null) {
            return new Lottos(Collections.emptyList());
        }
        List<Lotto> lottoList = new ArrayList<>();
        for (List<Lotto> lotto : lottos) {
            lottoList.addAll(lotto);
        }
        return new Lottos(lottoList);
    }

    public static Lottos of(Lottos... lottos) {
        if (lottos == null) {
            return new Lottos(Collections.emptyList());
        }
        List<Lotto> lottoList = new ArrayList<>();
        for (Lottos lotto : lottos) {
            lottoList.addAll(lotto.getLottoList());
        }
        return new Lottos(lottoList);
    }
}
