package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


class LottoTest {
    @Test
    @DisplayName("6개의 1~45 숫자가 정상적으로 저장되는지 테스트")
    void getNumberTest() {
        Lotto lotto = new Lotto(8, 21, 23, 41, 42, 43);
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(8, 21, 23, 41, 42, 43);
    }

    @Test
    @DisplayName("1~45 숫자가 외의 숫자가 입력시 Exception 발생하는지 테스트")
    void invalidNumberTest() {
        assertThatThrownBy(() -> new Lotto(0, 1, 2, 3, 4, 5)).isInstanceOf(IllegalArgumentException.class);
    }
}