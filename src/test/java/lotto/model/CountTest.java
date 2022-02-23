package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

    @DisplayName("수동 로또의 개수가 음수일 경우 생성을 실패한다")
    @Test
    void manualLottoCount_cannot_be_negative() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
            () -> new Count(5, -1));
    }

    @DisplayName("수동로또의 개수는 총 로또 개수보다 클 수 없다.")
    @Test
    void manualLottoCount_cannot_be_greater_than_totalLottoCount() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
            () -> new Count(5, 6));
    }

    @DisplayName("수동로또 개수로 자동 로또 개수를 계산한다")
    @Test
    void getAutolottoCount() {
        Count count = new Count(5, 1);
        assertThat(count.getAutoLottoCount()).isEqualTo(4);
    }
}
