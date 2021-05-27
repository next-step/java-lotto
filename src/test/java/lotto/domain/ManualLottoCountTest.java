package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class ManualLottoCountTest {

    @ParameterizedTest
    @CsvSource(value = {" :1000", "5:1000", "d:1000"}, delimiter = ':')
    void invalid(String count, String money) {
        // when
        Throwable thrown = catchThrowable(() -> new ManualLottoCount(count, new Money(money)));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void count() {
        // given
        ManualLottoCount manualLottoCount = new ManualLottoCount("3", new Money("10000"));

        // when
        int count = manualLottoCount.count();

        // then
        assertThat(count).isEqualTo(3);
    }
}
