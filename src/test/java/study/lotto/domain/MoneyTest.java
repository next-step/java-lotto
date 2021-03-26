package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @DisplayName("Money 생성 테스트")
    @Test
    void of_생성_테스트() {
        // given
        Money given = Money.of(1000);
        // when
        Money expected = Money.of(1000);
        // then
        assertThat(given).isEqualTo(expected);
    }

    @DisplayName("Money 자동 생성 카운트 쿼리 테스트")
    @Test
    void autoSize_자동_로또_카운트() {
        // given
        Money of = Money.of(1000);
        // when
        int autoSize = of.autoSize(1);
        // then
        assertThat(autoSize).isEqualTo(0);
    }
}
