package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoCreateByMission implements LottoCreateStrategy {

    @Override
    public Lotto create(LottoNumbers balls) {
        balls.shuffle();
        Set<Integer> lottoBalls = new HashSet<>(balls.getNumbers().subList(0, LOTTO_SIZE));
        return new Lotto(lottoBalls);
    }
}
