package lotto.step3.domain;

import java.util.HashSet;
import java.util.Set;

public class Lottery {
    private static final int LOTTO_COUNT = 6;
    private final Set<LottoNumber> lottery;

    public Lottery() {
        this.lottery = new HashSet<>();
    }

    public Lottery(Set<LottoNumber> lottery) {
        if (lottery.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는"+LOTTO_COUNT+"개 이어야 합니다.");
        }
        this.lottery = lottery;
    }

    @Override
    public String toString() {
        return lottery.toString();

    }
}
