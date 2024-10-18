package lotto.domain.purchase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static lotto.domain.purchase.PassivityLottoCount.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PassivityLottoCountTest {

    @Test
    @DisplayName("수동 로또 개수 유효성 검사 테스트 - 정상적인 수량 입력 시 유효함")
    void 수동_개수_입력_validate_성공_테스트() {
        assertThat(isValidate(new Money(3000), 1)).isEqualTo(1);
    }

    @Test
    @DisplayName("수동 로또 구매 개수가 구매 가능한 로또 개수를 초과할 때 예외가 발생해야 한다")
    void 수동_개수_입력_validate_에러_테스트() {
        assertThatThrownBy(() -> isValidate(new Money(3000), 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("수동 로또 구매 4개가 구매 가능한 로또 3개를 초과했습니다.");
    }
}