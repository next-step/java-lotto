package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoResult 클래스")
class LottoResultTest {

    @Nested
    @DisplayName("calculateEarningRate 메소드는")
    class Describe_calculateEarningRate {

        private final LottoResult lottoResult = new LottoResult(new LottoTicket(Set.of(1, 2, 3, 4, 5, 6)),
            LottoNumber.valueOf(7));

        @Nested
        @DisplayName("구매한 LottoTicket들이 들어오면")
        class Context_Input_Bought_Lotto_Tickets {

            private final List<LottoTicket> boughtLottoTickets = List.of(
                new LottoTicket(Set.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Set.of(2, 3, 4, 5, 6, 7)),
                new LottoTicket(Set.of(3, 4, 5, 6, 7, 8))
            );
            private final BigDecimal expectedEarningRate = BigDecimal.valueOf(676683.33);

            @Test
            @DisplayName("수익률을 계산한다")
            void It_Calculate_Earning_Rate() {
                assertThat(lottoResult.calculateEarningRate(boughtLottoTickets))
                    .isEqualTo(expectedEarningRate);
            }
        }

        @Nested
        @DisplayName("비어있는 LottoTicket들이 들어오면")
        class Context_Input_Empty_Lotto_Tickets {

            private final List<LottoTicket> emptyLottoTicket = List.of();

            @Test
            @DisplayName("IllegalArgumentException을 던진다")
            void It_Throw_IllegalArgumentException() {
                assertThatThrownBy(() -> lottoResult.calculateEarningRate(emptyLottoTicket))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
