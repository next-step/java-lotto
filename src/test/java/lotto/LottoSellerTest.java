package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.model.LottoSeller;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {
    @DisplayName("빈칸이 들어왔다.")
    @Test
    void blankTest() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoSeller("")).withMessage("알맞은 숫자를 입력해주세요.");
    }

    @DisplayName("null이 들어왔다.")
    @Test
    void nullTest() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoSeller(null)).withMessage("알맞은 숫자를 입력해주세요.");
    }

    @DisplayName("숫자가 아닌값이 들어왔다.")
    @Test
    void notIntegerTest() {
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> new LottoSeller("+")).withMessage("For input string: \"+\"");
    }

    @DisplayName("로또 최소금액 미달시 예외 발생")
    @Test
    void under1000Test() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoSeller("999")).withMessage("로또를 한장도 구매할 수 없습니다.");
    }

    @DisplayName("올바른 예")
    @Test
    void numberOfLotto() {
        LottoSeller lottoSeller = new LottoSeller("10000");

        assertThat(lottoSeller.getNumberOfLotto()).isEqualTo(10);
    }
}
