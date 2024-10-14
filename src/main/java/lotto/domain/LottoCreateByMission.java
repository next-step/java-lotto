package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoCreateByMission implements LottoCreateStrategy {

    private static final int LOTTO_SIZE = 6;

    @Override
    public Lotto create(LottoNumbers balls) {
        balls.shuffle();
        Set<LottoNo> lottoBalls = new HashSet<>(balls.getNumbers().subList(0, LOTTO_SIZE));
        return new Lotto(lottoBalls);
    }

    @Override
    public int getLottoSize() {
        return LOTTO_SIZE;
    }
}
