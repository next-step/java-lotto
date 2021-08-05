package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    @DisplayName("빈 문자열 이나 null 을 입력했을 때 boolean 값 확인")
    void checkEmptyAndNull() {
        Validation validation = new Validation("");
        assertThat(validation.checkEmptyAndNull()).isTrue();
    }

    @Test
    @DisplayName("빈 문자열 이나 null 을 입력했을 때 boolean 값 확인 2")
    void checkEmptyAndNull2() {
        Validation validation = new Validation(null);
        assertThat(validation.checkEmptyAndNull()).isTrue();
    }

    @Test
    @DisplayName("문자열로 숫자 하나를 입력 했는지 검증 하는 테스트")
    void onlyNumberTest() {
        Validation validation = new Validation("3");
        assertThat(validation.checkOnlyNumber()).isTrue();
    }

    @Test
    @DisplayName("문자열로 숫자 하나를 입력 했는지 검증 하는 테스트2")
    void onlyNumberTest2() {
        Validation validation = new Validation("s");
        assertThat(validation.checkOnlyNumber()).isFalse();
    }

    @Test
    @DisplayName("음수를 포함했을 때 예외처리 하는 테스트")
    void isNegativeNumber() {
        Calculator calculator = new Calculator("-1,2,4");
        assertThatThrownBy(() -> calculator.isNegativeNumber("-1")).isInstanceOf(RuntimeException.class);
    }
}