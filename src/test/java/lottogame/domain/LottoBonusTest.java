package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoBonus 클래스")
class LottoBonusTest {

    @Nested
    @DisplayName("equals 메서드는")
    class Describe_Eqauls {

        @Nested
        @DisplayName("같은 lotto number을 가지고 있으면")
        class Context_Same_Lotto_Number {

            private final int lottoNumber = 1;
            private final LottoBonus lottoBonus = new LottoBonus(lottoNumber);
            private final LottoBonus sameLottoBonus = new LottoBonus(lottoNumber);

            @Test
            @DisplayName("논리적으로 동일하다.")
            void It_Same_Objects() {
                assertThat(lottoBonus).isEqualTo(sameLottoBonus);
            }

        }

    }

}
