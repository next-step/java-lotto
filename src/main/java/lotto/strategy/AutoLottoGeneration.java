package lotto.strategy;

import lotto.LottoNumber;

import java.util.*;

import static java.util.Collections.shuffle;

public class AutoLottoGeneration implements LottoGeneration {

    private final List<LottoNumber> list;

    public AutoLottoGeneration(Collection<LottoNumber> list) {
        this.list = new ArrayList<>(list);
    }

    @Override
    public Set<LottoNumber> generate() {
        shuffle(list);

        return new HashSet<>(list.subList(0, 6));
    }
}
