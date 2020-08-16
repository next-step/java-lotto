package nextstep.lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumberTest {

    @Test
    @DisplayName("Number의 일급컬렉션 테스트")
    void number_일급컬렌션(){
        assertThat(new InputNumber("1")).isEqualTo(new InputNumber("1"));
    }

    @Test
    @DisplayName("Number의 일급컬렉션 Getter 테스트")
    void number_일급컬렌션_GetterTest(){
        assertThat(new InputNumber("1").getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 아닌 문자의 InputNumber 객체 생성 테스트")
    void transStringToInt_NotNumberFormat_Test(){
        assertThatThrownBy(() -> {
            new InputNumber("CleanCode");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수를 사용하여 InputNumber 객체 생성 테스트")
    void transStringToInt_negativeNumber_Test(){
        assertThatThrownBy(() -> {
            new InputNumber("-1");
        }).isInstanceOf(RuntimeException.class);
    }
}
