package lotto.step3.domain;

import java.util.Set;

public class Lottery {
    public static final int LOTTO_COUNT = 6;
    private static final int COUNT = 1;
    private static final int NO_COUNT = 0;
    private final Set<LottoNumber> lottery;

    public Lottery(Set<LottoNumber> lottery) {
        if (lottery.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는" + LOTTO_COUNT + "개 이어야 합니다.");
        }
        this.lottery = lottery;
    }

    public int matchWinningNumber(Winning winning) {
        int countOfMatch = 0;
        for (LottoNumber number : winning.getWinnerNumber().getLottery()) {
            countOfMatch += containWinning(number);
        }
        return countOfMatch;
    }

    private int containWinning(LottoNumber number) {
        if (lottery.contains(number)) {
            return COUNT;
        }
        return NO_COUNT;
    }

    public Set<LottoNumber> getLottery() {
        return lottery;
    }

    public boolean containBonus(Winning winning) {
        return lottery.contains(winning.getBonusNumber());
    }

    @Override
    public String toString() {
        return lottery.toString();
    }
}
