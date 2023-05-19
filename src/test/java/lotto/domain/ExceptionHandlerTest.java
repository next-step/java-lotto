package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlerTest {

    @Test
    @DisplayName(value = "입력 로또 번호 개수가 안 맞을 경우 검사")
    void test1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExceptionHandler.validLottoSize(Arrays.asList(1, 2, 3, 4));
        });
    }

    @Test
    @DisplayName(value = "입력 로또 번호 개수가 안 맞을 경우 검사")
    void test2() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExceptionHandler.validLottoSize(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        });
    }

    @Test
    @DisplayName(value = "입력 로또 번호 범위가 안 맞을 경우 검사")
    void test3() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExceptionHandler.validLottoNumberRange(Arrays.asList(0, 1, 2, 3, 4, 5));
        });
    }

    @Test
    @DisplayName(value = "입력 로또 번호 범위가 안 맞을 경우 검사")
    void test4() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExceptionHandler.validLottoNumberRange(Arrays.asList(1, 2, 3, 4, 5, 46));
        });
    }

    @Test
    @DisplayName(value = "입력 금액이 천원 이하일 경우")
    void test5() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExceptionHandler.validPrice(900);
        });
    }

    @Test
    @DisplayName(value = "입력 금액이 천원 이하일 경우")
    void test6() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExceptionHandler.validDuplicatedBonusNumber(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 6);
        });
    }
}
