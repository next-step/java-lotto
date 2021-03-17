package study.lotto.service;

import study.lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

/**
 * Lotto 클래스의 일급 컬렉션
 */
public class Lottos {

    private final List<Lotto> lotteries;

    public Lottos(final List<Lotto> collect) {
        this.lotteries = collect;
    }

    public List<Lotto> getLotteries() {
        return Collections.unmodifiableList(lotteries);
    }
}
