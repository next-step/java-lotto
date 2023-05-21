package lotto.domain;

import lotto.domain.result.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName(value = "로또 최소 구매 금액 검사")
    void test1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.getLottoCount(900);
        });
    }

    @Test
    @DisplayName(value = "입력 로또번호와 보너스 번호가 중복되는지 검사")
    void test2() {
        assertThat(lotto.containsBonusNumber(3)).isTrue();
        assertThat(lotto.containsBonusNumber(7)).isFalse();
    }

    @Test
    @DisplayName(value = "입력 로또번호중 중복된 번호가 있을경우 예외 검사")
    void test3() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.of(Arrays.asList(1, 1, 2, 3, 4, 5));
        });
    }

    @Test
    @DisplayName(value = "입력 로또 번호 개수가 안 맞을 경우 검사")
    void test4() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.of(Arrays.asList(1, 2, 3, 4));
            Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        });
    }

    @Test
    @DisplayName(value = "입력 로또 번호 범위가 안 맞을 경우 검사")
    void test5() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.of(Arrays.asList(0, 1, 2, 3, 4, 5));
            Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 46));
        });
    }
}
