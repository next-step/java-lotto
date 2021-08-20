package lotto.step4.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottery {
    public static final int LOTTO_COUNT = 6;
    private static final int COUNT = 1;
    private static final int NO_COUNT = 0;
    private final Set<LottoNumber> lottery;

    public Lottery(List<LottoNumber> lottoNumbers) {
        this(new HashSet<>(lottoNumbers));
    }

    public Lottery(Set<LottoNumber> lottery) {
        if (lottery.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는" + LOTTO_COUNT + "개 이어야 합니다.");
        }
        this.lottery = lottery;
    }

    public int match(Lottery winnerNumber) {
        int countOfMatch = 0;
        for (LottoNumber winningNumber : winnerNumber.lottery) {
            countOfMatch += containLottoNumber(winningNumber);
        }
        return countOfMatch;
    }

    private int containLottoNumber(LottoNumber lottoNumber) {
        if (lottery.contains(lottoNumber)) {
            return COUNT;
        }
        return NO_COUNT;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottery.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottery.toString();
    }


}
