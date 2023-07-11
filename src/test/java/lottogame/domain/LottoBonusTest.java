package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoBonus 클래스")
class LottoBonusTest {

    private final LottoNumbers defaultLottoNumbers = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6));

    @Nested
    @DisplayName("equals 메서드는")
    class Describe_Eqauls {

        @Nested
        @DisplayName("같은 lotto number을 가지고 있으면")
        class Context_Same_Lotto_Number {

            private final int lottoNumber = 7;
            private final LottoBonus lottoBonus = new LottoBonus(lottoNumber, defaultLottoNumbers);
            private final LottoBonus sameLottoBonus = new LottoBonus(lottoNumber, defaultLottoNumbers);

            @Test
            @DisplayName("논리적으로 동일하다.")
            void It_Same_Objects() {
                assertThat(lottoBonus).isEqualTo(sameLottoBonus);
            }
        }
    }

    @Nested
    @DisplayName("new 생성자는")
    class Describe_New_Constructor {

        @Nested
        @DisplayName("로또 번호들과 보너스 번호가 중복되면")
        class Context_Contained_In_Lotto_Numbers {

            private final int bonusNumber = 1;

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void It_Throw_IllegalArgumentException() {
                assertThatThrownBy(() -> new LottoBonus(bonusNumber, defaultLottoNumbers)).isInstanceOf(
                    IllegalArgumentException.class);
            }


        }


    }


}
