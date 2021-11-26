package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private static final int MIN_COUNT = 0;

    private final List<Lotto> lottos;

    public Lottos(int count) {
        this(new ArrayList<>());
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("구매 개수는 0 미만일 수 없습니다.");
        }

        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.pickRandomNumber());
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Ranks checkWinning(Lotto winLotto) {
        return new Ranks(lottos.stream()
                .mapToInt(winLotto::countMatch)
                .mapToObj(Rank::valueOf)
                .collect(Collectors.toList())
        );
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int size() {
        return this.lottos.size();
    }

}
