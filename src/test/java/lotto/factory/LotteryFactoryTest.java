package lotto.factory;

import lotto.domain.LotteryNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LotteryFactoryTest {

    @DisplayName("번호를 입력하여 lotto 생성")
    @Test
    void create() {
        List<LotteryNumber> numbers = LotteryFactory.create("1,2,3,4,5,45");
        assertAll(
                () -> assertThat(numbers.get(0)).isEqualTo(LotteryNumber.of(1)),
                () -> assertThat(numbers.get(1)).isEqualTo(LotteryNumber.of(2)),
                () -> assertThat(numbers.get(2)).isEqualTo(LotteryNumber.of(3)),
                () -> assertThat(numbers.get(3)).isEqualTo(LotteryNumber.of(4)),
                () -> assertThat(numbers.get(4)).isEqualTo(LotteryNumber.of(5)),
                () -> assertThat(numbers.get(5)).isEqualTo(LotteryNumber.of(45))
        );
    }

    @DisplayName("입력한 번호가 정렬해서 출력되는지 확인")
    @Test
    void sort() {
        List<LotteryNumber> numbers = LotteryFactory.create("1,7,3,45,22,33");
        assertAll(
                () -> assertThat(numbers.get(0)).isEqualTo(LotteryNumber.of(1)),
                () -> assertThat(numbers.get(1)).isEqualTo(LotteryNumber.of(3)),
                () -> assertThat(numbers.get(2)).isEqualTo(LotteryNumber.of(7)),
                () -> assertThat(numbers.get(3)).isEqualTo(LotteryNumber.of(22)),
                () -> assertThat(numbers.get(4)).isEqualTo(LotteryNumber.of(33)),
                () -> assertThat(numbers.get(5)).isEqualTo(LotteryNumber.of(45))
        );
    }

    @DisplayName("lotto 번호로 5개의 번호만 입력하였을 때")
    @Test
    void create_input5Numbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> LotteryFactory.create("1,2,3,4,5"))
                .withMessageContaining("로또 당첨 번호는 6개의 숫자를 입력해야 합니다.");
    }

    @DisplayName("lotto에 포함되지 않는 숫자 입력")
    @Test
    void create_inputOver45() {
        assertThatIllegalArgumentException().isThrownBy(() -> LotteryFactory.create("1,2,3,4,5,46"))
                .withMessageContaining("로또 당첨 번호는 1 이상 45 이하의 수 입니다.");
    }

    @DisplayName("lotto 번호 입력시 문자 입력")
    @Test
    void create_inputString() {
        assertThatThrownBy(() -> LotteryFactory.create("1,2,3,4,5,invalidString"))
                .isInstanceOf(NumberFormatException.class);
    }
}