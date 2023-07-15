package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;
import lottogame.domain.dto.LottoTicketDto;
import lottogame.domain.spi.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoPurchaseManager 클래스")
class LottoPurchaseManagerTest {

    @Nested
    @DisplayName("purchase 메소드는")
    class Describe_Buy {

        private final NumberGenerator stubNumberGenerator = (count) -> Set.of(1, 2, 3, 4, 5, 6);
        private final LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(stubNumberGenerator);

        @Nested
        @DisplayName("1000원으로 나누어 떨어지지 않으면,")
        class Context_Not_Divided_By_1000 {

            private final List<LottoTicketDto> emptyList = List.of();
            private final int notDividedMoney = 1001;

            @Test
            @DisplayName("IllegalArgumentException 을 던진다")
            void It_Throw_IllegalArgumentException() {
                assertThatThrownBy(() -> lottoPurchaseManager.purchase(notDividedMoney, emptyList)).isInstanceOf(
                    IllegalArgumentException.class);
            }

        }

        @Nested
        @DisplayName("돈, 수동으로 구매할 로또 티켓 들, 각 로또 티켓의 숫자들을 입력받으면,")
        class Context_Input_Money_Ticket_Numbers {

            private final int totalMoney = 3000;
            private final List<LottoTicketDto> passiveLottoTicketRequest = List.of(
                new LottoTicketDto(Set.of(1, 2, 3, 4, 5, 6)), new LottoTicketDto(Set.of(7, 8, 9, 10, 11, 12)));

            @Test
            @DisplayName("수동으로 구매한 로또티켓과 자동으로 구매한 로또티켓을 반환한다.")
            void It_Return_Purchased_LottoTicket() {
                List<LottoTicketDto> response = lottoPurchaseManager.purchase(totalMoney, passiveLottoTicketRequest);

                assertThat(response).hasSize(3).containsAll(passiveLottoTicketRequest);
            }

        }

        @Nested
        @DisplayName("입력한 금액보다, 수동으로 구매할 로또가 많으면,")
        class Context_Input_Overflow_Passive_Lottos {

            private final int totalMoney = 1000;
            private final List<LottoTicketDto> passiveLottoTicketRequest = List.of(
                new LottoTicketDto(Set.of(1, 2, 3, 4, 5, 6)), new LottoTicketDto(Set.of(7, 8, 9, 10, 11, 12)));

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void It_Return_ThrowIllegalArgumentException() {
                assertThatThrownBy(() -> lottoPurchaseManager.purchase(totalMoney, passiveLottoTicketRequest))
                    .isInstanceOf(IllegalArgumentException.class);
            }

        }

    }

}
