package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LotteryNumberTest {

    @DisplayName("로또 번호 정적 팩터리 메서드로 생성")
    @Test
    void construct() {
        LotteryNumber lotteryNumber = LotteryNumber.of("1");
        assertThat(lotteryNumber).isNotNull();
        assertThat(LotteryNumber.of(1) == lotteryNumber).isTrue();
    }

    @DisplayName("로또 번호 생성시 적절하지 않는 문자 입력")
    @Test
    void construct_inputText() {
        assertThatThrownBy(() -> LotteryNumber.of("text"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("lotto에 포함되지 않는 숫자 입력")
    @Test
    void create_inputOver45() {
        assertThatIllegalArgumentException().isThrownBy(() -> LotteryNumber.of("46"))
                .withMessageContaining("로또 당첨 번호는 1 이상 45 이하의 수 입니다.");
    }

}