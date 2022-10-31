package lotto.strategy;

import static lotto.exception.ExceptionMessage.ERROR_MISMATCH_QUANTITY;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualIssueLottoStrategyTest {

    @Test
    @DisplayName("입력한 구매 수량과 할당된 로또 번호 수가 같지 않으면 에러가 발생한다.")
    void issue() {
        List<String> value = List.of(
            "1, 2, 3, 4, 5, 6",
            "2, 3, 4, 5, 6, 7",
            "3, 4, 5, 6, 7, 8"
        );
        ManualIssueLottoStrategy strategy = new ManualIssueLottoStrategy(value);

        assertThatThrownBy(() -> strategy.issue(2))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_MISMATCH_QUANTITY.getMessage());
    }
}