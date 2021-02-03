package lotto.domain;

import java.util.Objects;

public class LottoAnswer {
    private static final String BONUS_NUMBER_INCLUDE_ERROR_MSG = "보너스 번호는 정답 번호와 달라야 합니다.";

    private final LottoTicket answer;
    private final LottoNumber bonus;

    public LottoAnswer(LottoTicket answer, LottoNumber bonus) {
        if (answer.includeNumber(bonus)) {
            throw new RuntimeException(BONUS_NUMBER_INCLUDE_ERROR_MSG);
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
