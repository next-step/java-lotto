package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualQuantityTest {

    @Test
    @DisplayName("수동 구매 숫자가 입력된 경우 정상 객체를 생성한다.")
    void createObjTest() {
        assertDoesNotThrow(() -> new ManualQuantity(5));
    }

    @Test
    @DisplayName("총 구매 수량보다 수동 희망 수가 더 클경우 true 를 반환한다.")
    void beyondTheAmountTest() {
        assertThat(new ManualQuantity(6).beyondTheAmount(5))
                .isTrue();
    }
}