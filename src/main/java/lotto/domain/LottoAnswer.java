package lotto.domain;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.Objects;

public class LottoAnswer {
    private LottoTicket answer;
    private LottoNumber bonus;

    public LottoAnswer(LottoTicket answer, LottoNumber bonus) {
        if (answer.includeNumber(bonus)) {
            throw new RuntimeException();
        }

        this.answer = answer;
        this.bonus = bonus;
    }

    public LottoScore calculateScore(LottoTicket candidate) {
        return LottoScore.calculateScore(
            candidate.getMatchedCnt(answer),
            candidate.includeNumber(bonus)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoAnswer that = (LottoAnswer) o;
        return Objects.equals(answer, that.answer) && Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, bonus);
    }
}
