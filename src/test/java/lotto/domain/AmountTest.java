package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {
    @Test
    void Amount는_최솟값_미만으로_생성_할_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new Amount(Amount.MIN - 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Amount는_숫자가_아닌_문자열로_생성_할_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new Amount("문자");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
