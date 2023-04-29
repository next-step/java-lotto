package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PurchasedAmountTest {

    @Test
    @DisplayName("최소 구입금액 1000원 이상 입력시 정상수행됩니다.")
    void test01() {
        assertAll(
                () -> assertThatNoException().isThrownBy(() -> new PurchasedAmount(1_000)),
                () -> assertThatNoException().isThrownBy(() -> new PurchasedAmount(2_000))
        );
    }

    @Test
    @DisplayName("최소 구입금액 1000원 보다 입력이 작을 경우 에러가 발생합니다.")
    void test02() {
        assertAll(
                () -> assertThatThrownBy(() -> new PurchasedAmount(900))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new PurchasedAmount(0))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("수동 로또 개수가 전체 구입가능한 금액을 넘을 경우 에러가 발생합니다.")
    void test03() {
        assertThatNoException().isThrownBy(() -> new PurchasedAmount(1_000, 1));
    }

    @Test
    @DisplayName("수동 로또 개수가 전체 구입가능한 금액을 넘을 경우 에러가 발생합니다.")
    void test04() {
        assertThatThrownBy(() -> new PurchasedAmount(1_000, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

}