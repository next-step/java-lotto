package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    void createTest_MaxSize(){
        var actualNumber = new Number(44);
        var expectValue = 44;

        assertThat(actualNumber.getNumberToInt())
                .isEqualTo(expectValue);
    }

    @Test
    void createTest_MaxSize_넘김(){
        assertThatThrownBy(() -> new Number(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1~45사이만 입력 가능합니다.");
    }

    @Test
    void createTest_MaxSize_음수(){
        assertThatThrownBy(() -> new Number(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 음수가 될 수 없습니다.");
    }
}