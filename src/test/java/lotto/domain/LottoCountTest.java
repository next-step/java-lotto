package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCountTest {
    @Test
    public void 생성() {
        assertThat(new LottoCount("3")).isEqualTo(new LottoCount(3));
    }

    @Test
    public void 증가() {
        assertThat(new LottoCount(0).increase()).isEqualTo(new LottoCount(1));
    }

    @Test
    public void 로또_개수_계산() {
        assertThat(LottoCount.getAutoCount("5000", "3")).isEqualTo(new LottoCount(2));
    }
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, false",
    })
    public void 카운트_일치_여부(int count, boolean expected) {
        assertThat(new LottoCount(count).isCountSame(1)).isEqualTo(expected);
    }
}
