package step4.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TicketDTOTest {

    @DisplayName("TicketDTO 생성 시 0이하의 총 구매금액을 입력하면 예외처리한다")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -3000, 0})
    void price_can_positive(int negativePrice) {
        Assertions.assertThatThrownBy(() -> TicketDTO.of(negativePrice, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("TicketDTO 생성 시 총 구매 가격을 1000원 단위로 입력하지 않으면 예외처리 한다")
    @ParameterizedTest
    @ValueSource(ints = {500, 3500, 10005})
    void price_can_1000s_multiply(int price) {
        Assertions.assertThatThrownBy(() -> TicketDTO.of(price, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("TicketDTO 생성 시 총 구매 금액보다 수동 로또를 많이 사면 예외처리 한다")
    @Test
    void manualLottoCount_can_less_than_purchasePrice(){
        Assertions.assertThatThrownBy(() -> TicketDTO.of(3000, 4)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}