package lottogame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoRank 클래스")
class LottoRankTest {

    @Nested
    @DisplayName("of 메소드는")
    class Describe_Of {

        @Nested
        @DisplayName("맞은 갯수와 보너스번호당첨 유무를 받으면")
        class Context_Input_Matched_Count_And_Bonus {

            @Test
            @DisplayName("등수를 반환한다")
            void It_Return_Lotto_Prize() {
                Assertions.assertThat(LottoRank.of(6, false)).isEqualTo(LottoRank.FIRST);
                Assertions.assertThat(LottoRank.of(5, true)).isEqualTo(LottoRank.SECOND);
                Assertions.assertThat(LottoRank.of(5, false)).isEqualTo(LottoRank.THIRD);
                Assertions.assertThat(LottoRank.of(4, false)).isEqualTo(LottoRank.FORTH);
                Assertions.assertThat(LottoRank.of(3, false)).isEqualTo(LottoRank.FIFTH);
                Assertions.assertThat(LottoRank.of(0, false)).isEqualTo(LottoRank.NONE);
            }
        }
    }
}
