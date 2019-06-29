package step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoRankTest {

    @Test
    @DisplayName("당첨 등수 1등")
    void check_my_rank() {
        Lotto lotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        LottoRank rank = lotto.matchLottoNumber(new WinningLotto(Lotto.create(List.of(1, 2, 3, 4, 5, 6))));
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("맞춘 공 개수 매칭")
    void match_number() {
        assertThat(LottoRank.matchOf(5)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("맞춘 공 개수 매칭 실패")
    void match_number_fail() {
        assertThat(LottoRank.matchOf(7)).isEqualTo(LottoRank.NO_RANK);
    }

    @Test
    @DisplayName("랭크 매칭")
    void match_rank() {
        assertThat(LottoRank.rankOf(3)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("랭크 매칭 실패")
    void match_rank_fail() {
        assertAll(
            () -> assertThat(LottoRank.rankOf(0)).isEqualTo(LottoRank.NO_RANK),
            () -> assertThat(LottoRank.rankOf(7)).isEqualTo(LottoRank.NO_RANK)
        );
    }

}
