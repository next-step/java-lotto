package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoRankTest {

    @DisplayName("매칭 카운트를 전달하면 LottoRankingSystem 객체를 전달한다.")
    @Test
    void create() {
        LottoRank actual = LottoRank.from(6, Boolean.FALSE);

        assertThat(actual).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("로또 번호 일치 갯수가 로또 랭킹에 들지않는 갯수라면 NOT_RANKED 필드를 반환한다.")
    @Test
    void return_NOT_RANKED_when_matchingCount_is_not_included_in_rankingSystem() {
        LottoRank actual = LottoRank.from(2, Boolean.FALSE);

        assertThat(actual).isEqualTo(LottoRank.NON_RANKED);
    }

    @DisplayName("로또 번호 일치 갯수가 5개이고 보너스 번호가 일치하다면 SECOND 필드를 반환한다.")
    @Test
    void return_SECOND_when_matchingCount_is_fifth_and_bonusBall_is_matched() {
        LottoRank actual = LottoRank.from(5, Boolean.TRUE);

        assertThat(actual).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("로또 갯수를 벗어난 매칭 카운트를 전달하면 IllegalArgumentException 를 발생시킨다.")
    @Test
    void throw_IllegalArgumentException_when_matchingCount_is_not_() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.from(7, Boolean.FALSE))
                .withMessage("로또 번호 매칭 갯수 '7'은 적합하지 않습니다.");
    }

    @DisplayName("우승 랭킹이 아닌 상수를 제외하고 반환한다.")
    @Test
    void return_winningRanks() {
        LottoRank[] actual = LottoRank.winningRanks();

        assertThat(actual).doesNotContain(LottoRank.NON_RANKED);
    }
}
