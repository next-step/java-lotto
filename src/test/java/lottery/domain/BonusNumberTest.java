package lottery.domain;

import static lottery.domain.LotteryNumber.MAX;
import static lottery.domain.LotteryNumber.MIN;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    @DisplayName("1 ~ 45 로또 정상 범주에 속하는 번호 입력시 객체가 생성된다.")
    void objCreateTest() {
        assertDoesNotThrow(() -> new BonusNumber(MAX));
    }

    @Test
    @DisplayName("1 ~ 45 범위 밖 숫자 입력시 익셉션을 발생시킨다.")
    void objErrorTest() {
        assertThatThrownBy(() -> new BonusNumber(MIN - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1~45 의 정수만 입력 될 수 있습니다.");
    }
    

}