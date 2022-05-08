package lotto.model;

import lotto.exception.LottoSizeException;
import lotto.util.AwardNumberUtil;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class LotteryTickets {

    private final List<Lotto> value;

    public LotteryTickets(List<Lotto> value) {
        validate(value.size());
        this.value = value;
    }

    public void findGrade(Lotto winLotto, int bonus) {
        Set<Integer> winningNumbers = winLotto.numbers();
        for (Lotto lotto : value) {
            Set<Integer> selectNumbers = lotto.numbers();
            LotteryResults.increase(AwardNumberUtil.matchCount(selectNumbers, winningNumbers, bonus));
        }
    }

    private void validate(int size) {
        if (size < 0) {
            throw new LottoSizeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LotteryTickets that = (LotteryTickets) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
