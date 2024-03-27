package lotto.domain;

import static lotto.config.LottoExceptionMessage.LOTTO_RANK_IS_NOT_FOUND;
import static lotto.domain.LottoRank.FIRST;
import static lotto.domain.LottoRank.NONE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    @DisplayName("로또 번호 매칭 개수가 최소 기준보다 적은 경우 예외를 던진다.")
    void LottoRank_MatchingCountLessThanMinimum_Exception() {
        final int matchingCountLessThanMinimum = NONE.matchingCount() - 1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.from(matchingCountLessThanMinimum))
                .withMessage(LOTTO_RANK_IS_NOT_FOUND.message(matchingCountLessThanMinimum));
    }

    @Test
    @DisplayName("로또 번호 매칭 개수가 최대 기준보다 많은 경우 예외를 던진다.")
    void LottoRank_MatchingCountMoreThanMaximum_Exception() {
        final int matchingCountMoreThanMaximum = FIRST.matchingCount() + 1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.from(matchingCountMoreThanMaximum))
                .withMessage(LOTTO_RANK_IS_NOT_FOUND.message(matchingCountMoreThanMaximum));
    }
}
