package lottosecond.domain.lotto;

import lottosecond.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TotalLottoCountTest {

    private TotalLottoCount totalLottoCount;

    @BeforeEach
    void setUp() {
        totalLottoCount = new TotalLottoCount(new Money(13000), 10);
    }

    @DisplayName("수동 로또 개수를 반환합니다.")
    @Test
    void manualLottoCount() {
        // given
        // when
        int result = totalLottoCount.manualLottoCount();
        // then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("자동 로또 개수를 반환합니다.")
    @Test
    void autoLottoCount() {
        // given
        // when
        int result = totalLottoCount.autoLottoCount();
        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("전체 로또 개수를 반환합니다.")
    @Test
    void totalLottoCount() {
        // given
        // when
        int result = totalLottoCount.totalLottoCount();
        // then
        assertThat(result).isEqualTo(13);
    }

}