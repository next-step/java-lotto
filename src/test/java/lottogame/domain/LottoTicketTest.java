package lottogame.domain;

import lottogame.domain.mock.MockLottoTicket;
import lottogame.domain.spi.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoTicket 클래스")
class LottoTicketTest {

    @Nested
    @DisplayName("new 생성자는")
    class Describe_New_Constructor {

        @Nested
        @DisplayName("6개의 int값으로")
        class Context_Input_Six_Integer {

            private final Set<Integer> lottoValues = Set.of(1, 2, 3, 4, 5, 45);

            @Test
            @DisplayName("생성할 수 있다.")
            void It_Create_Success() {
                assertThatCode(() -> new MockLottoTicket(lottoValues)).doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("6개의 int값이 아니면")
        class Context_Input_Non_Six_Integer {

            private final Set<Integer> lessLottoValues = Set.of(1, 2, 3, 4, 5);
            private final Set<Integer> moreLottoValues = Set.of(1, 2, 3, 4, 5, 6, 7);

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void It_Throw_IllegalArgumentException() {
                assertThatThrownBy(() -> new MockLottoTicket(lessLottoValues)).isInstanceOf(
                    IllegalArgumentException.class);
                assertThatThrownBy(() -> new MockLottoTicket(moreLottoValues)).isInstanceOf(
                    IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("null 파라미터가 입력되면")
        class Context_Input_Null_Parameter {

            @ParameterizedTest
            @NullSource
            @DisplayName("NullPointerException을 던진다.")
            void It_Throw_IllegalArgumentException(Set<Integer> nullValue) {
                assertThatThrownBy(() -> new MockLottoTicket(nullValue)).isInstanceOf(NullPointerException.class);
            }
        }

        @Nested
        @DisplayName("numberGenerator가 들어오면")
        class Context_Input_NumberGenerator {

            private final NumberGenerator numberGenerator = (count) -> Set.of(1, 2, 3, 4, 5, 45);

            @Test
            @DisplayName("생성할 수 있다.")
            void It_Create_Success() {
                assertThatCode(() -> new MockLottoTicket(numberGenerator)).doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("numberGenerator로 null이 들어오면")
        class Context_Input_Null_NumberGenerator {

            private final NumberGenerator nullNumberGenerator = null;

            @Test
            @DisplayName("NullPointerException을 던진다.")
            void It_Throw_NullPointerException() {
                assertThatThrownBy(() -> new MockLottoTicket(nullNumberGenerator)).isInstanceOf(
                    NullPointerException.class);
            }

        }

    }

    @Nested
    @DisplayName("equals는")
    class Describe_Equals {

        @Nested
        @DisplayName("같은 LottoNumbers 를 가지고 있으면,")
        class Context_Same_Lotto_Numbers {

            private final Set<Integer> lottoNumbers = Set.of(1, 2, 3, 4, 5, 45);
            private final LottoTicket lottoTicket = new MockLottoTicket(lottoNumbers);
            private final LottoTicket sameLottoTicket = new MockLottoTicket(lottoNumbers);

            @Test
            @DisplayName("논리적으로 동일하다")
            void It_Same_Objects() {
                assertThat(lottoTicket).isEqualTo(sameLottoTicket);
            }

        }
    }

    @Nested
    @DisplayName("contain 메소드는")
    class Describe_Conatins {

        @Nested
        @DisplayName("중복된 LottoNumber가 들어오면,")
        class Context_Input_Same_LottoNumber {

            private static final int SAME_LOTTO_NUMBER = 1;
            private final LottoTicket lottoTicket = new MockLottoTicket(Set.of(SAME_LOTTO_NUMBER, 2, 3, 4, 5, 6));
            private final LottoNumber lottoNumber = LottoNumber.valueOf(SAME_LOTTO_NUMBER);

            @Test
            @DisplayName("true를 반환한다.")
            void It_Return_True() {
                assertThat(lottoTicket.contains(lottoNumber)).isTrue();
            }
        }
    }

    @Nested
    @DisplayName("getMatchedCount 메소드는")
    class Describe_Get_Matched_Count {

        @Nested
        @DisplayName("lottoNumbers를 받으면,")
        class Context_Input_Lotto_Numbers {

            private final Set<Integer> lottoNumberNumbers = Set.of(1, 2, 3, 4, 5, 6);
            private final LottoTicket lottoTicket = new MockLottoTicket(lottoNumberNumbers);
            private final LottoTicket sameLottoTicket = new MockLottoTicket(lottoNumberNumbers);

            @Test
            @DisplayName("일치한 갯수를 반환한다.")
            void It_Return_Matched_Count() {
                assertThat(lottoTicket.getMatchedCount(sameLottoTicket)).isEqualTo(lottoNumberNumbers.size());
            }
        }
    }
}
