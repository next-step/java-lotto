package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.domain.LottoAward;
import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningNumber;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int AWARD_2ND_OR_3RD = 5;
    private static final int WIN = 1;
    private static final int LOSE = 0;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }


    public LottoAward getAwardResult(LottoWinningNumber winningNumber) {
        int matchCount = getMatchCount(winningNumber);
        return LottoAward.valueOf(matchCount,
                getBonusMatchResult(matchCount, winningNumber));
    }

    private int getMatchCount(LottoWinningNumber winningNumber) {
        return this.numbers
                .stream()
                .mapToInt(number -> winningNumber.contain(number) ? WIN : LOSE)
                .sum();
    }

    private boolean getBonusMatchResult(int matchCount, LottoWinningNumber winningNumber) {
        if (AWARD_2ND_OR_3RD == matchCount) {
            return this.numbers.stream().anyMatch(winningNumber::containBonus);
        }
        return false;
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
