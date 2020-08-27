package lotto.domain;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.*;

public class Lottos {
    private final List<Lotto> lottoList;
    private final int lottoCount;

    public Lottos(List<Lotto> lottoList, int lottoCount) {
        this.lottoList = lottoList;
        this.lottoCount = lottoCount;
    }

    public static Lottos of(int lottoPrice) {
        int count = lottoPrice / 1000;
        return new Lottos(
                Stream.generate(() -> Lotto.createLotto())
                .limit(count)
                .collect(Collectors.toList()), count);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
