package enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoPrizeTest {

    @DisplayName("매칭된 번호 개수에 맞는 상금 확인")
    @Test
    @CsvSource(value = {""})
    public void prize() throws Exception {
        assertAll(
                () -> assertThat(LottoPrize.MATCH3.calculate(3)).isEqualTo(15000),
                () -> assertThat(LottoPrize.MATCH3.calculate(4)).isEqualTo(20000),
                () -> assertThat(LottoPrize.MATCH4.calculate(4)).isEqualTo(200000),
                () -> assertThat(LottoPrize.MATCH5.calculate(4)).isEqualTo(6000000),
                () -> assertThat(LottoPrize.MATCH6.calculate(2)).isEqualTo(4000000000.0)
        );
    }
}
