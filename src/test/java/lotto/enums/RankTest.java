package lotto.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @DisplayName("5개가 일치하고, 보너스 볼을 넣었을 때 2, 3등 당첨")
    @CsvSource(value = {"5,true,SECOND_RANK", "5,false,THIRD_RANK"})
    void 당첨_2등(int matchCount, boolean isMatchBonus, Rank rank) {
        Assertions.assertThat(Rank.getRank(matchCount, isMatchBonus)).isEqualTo(rank);
    }

    @ParameterizedTest
    @DisplayName("맞은 개수에 따라 상금을 반환한다.")
    @CsvSource(value = {"6,2000000000", "5,1500000", "4,50000", "3,5000"})
    void 상금_반환(int matchCount, int price) {
        assertThat(Rank.getRank(matchCount, false).getPrice()).isEqualTo(price);
    }

    @Test
    @DisplayName("list 조회를 하면 등록된 상의 개수만큼 반환한다.")
    void enum_개수_반환() {
        assertThat(Rank.getLottoWinnerPrice()).hasSize(5);
    }
}