package domain;

import calculator.domain.Input;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("실패 - 입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생한다.")
    void fail_input_null_or_empty(String text){
        // given & when & then
        Assertions.assertThatThrownBy(() -> new Input(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null이거나 빈 공백 문자일 수 없습니다.");
    }

}
