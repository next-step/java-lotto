package lottogame.domain;

import lottogame.domain.mock.MockLottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoBonus 클래스")
class LottoBonusTest {

    private final Set<Integer> defaultLottoNumberValues = Set.of(1, 2, 3, 4, 5, 6);
    private final LottoTicket defaultLottoTicket = new MockLottoTicket(defaultLottoNumberValues);

    @Nested
    @DisplayName("equals 메서드는")
    class Describe_Eqauls {

        @Nested
        @DisplayName("같은 lotto number을 가지고 있으면")
        class Context_Same_Lotto_Number {

            private static final int LOTTO_NUMBER = 7;
            private final LottoBonus lottoBonus = new LottoBonus(LOTTO_NUMBER, defaultLottoTicket);
            private final LottoBonus sameLottoBonus = new LottoBonus(LOTTO_NUMBER, defaultLottoTicket);

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

            private static final int BONUS_NUMBER = 1;

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void It_Throw_IllegalArgumentException() {
                assertThatThrownBy(() -> new LottoBonus(BONUS_NUMBER, defaultLottoTicket)).isInstanceOf(
                    IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("isContained 는")
    class Describe_Is_Contained {

        private final LottoTicket lottoTicketForResult = new MockLottoTicket(Set.of(10, 11, 12, 13, 14, 15));

        @Nested
        @DisplayName("lottoNumbers에 보너스가 포함되면")
        class Context_Bonus_Is_Contained_Lotto_Numbers {

            private static final int CONTAINED_BONUS_NUMBER = 1;
            private final LottoBonus lottoBonus = new LottoBonus(CONTAINED_BONUS_NUMBER, lottoTicketForResult);

            @Test
            @DisplayName("true를 반환한다")
            void It_Return_True() {
                assertThat(lottoBonus.isContained(defaultLottoTicket)).isTrue();
            }
        }

        @Nested
        @DisplayName("lottoNumbers에 보너스가 포함되지 않는다면")
        class Context_Bonus_Is_Not_Contained_Lotto_Numbers {

            private static final int NOT_CONTAINED_BONUS_NUMBER = 7;
            private final LottoBonus lottoBonus = new LottoBonus(NOT_CONTAINED_BONUS_NUMBER, lottoTicketForResult);

            @Test
            @DisplayName("false를 반환한다")
            void It_Return_False() {
                assertThat(lottoBonus.isContained(defaultLottoTicket)).isFalse();
            }
        }
    }
}
