package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Domain.InputNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class InputNumberTest {

    @Test
    @DisplayName("입력 번호에 대한 생성 및 검증 테스트")
    void inputNumberTest() {
        String number = "1,2, 3 , 4 , 5 , 6";
        InputNumber inputNumber = new InputNumber(number);
        assertThat(inputNumber.numbers()).hasSize(6);
    }
}
