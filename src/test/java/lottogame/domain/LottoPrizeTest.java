package lottogame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoNumber 클래스")
class LottoPrizeTest {

    @Nested
    @DisplayName("of 메소드는")
    class Describe_Of {

        @Nested
        @DisplayName("맞은 갯수와 보너스번호당첨 유무를 받으면")
        class Context_Input_Matched_Count_And_Bonus {

            @Test
            @DisplayName("등수를 반환한다")
            void It_Return_Lotto_Prize() {
                Assertions.assertThat(LottoPrize.of(6, false)).isEqualTo(LottoPrize.FIRST);
                Assertions.assertThat(LottoPrize.of(5, true)).isEqualTo(LottoPrize.SECOND);
                Assertions.assertThat(LottoPrize.of(5, false)).isEqualTo(LottoPrize.THIRD);
                Assertions.assertThat(LottoPrize.of(4, false)).isEqualTo(LottoPrize.FORTH);
                Assertions.assertThat(LottoPrize.of(3, false)).isEqualTo(LottoPrize.FIFTH);
                Assertions.assertThat(LottoPrize.of(0, false)).isEqualTo(LottoPrize.NONE);
            }
        }
    }
}
