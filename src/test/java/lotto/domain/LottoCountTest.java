package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class LottoCountTest {
    @Test
    public void 생성() {
        assertThat(new LottoCount("3")).isEqualTo(new LottoCount(3));
    }

    @Test
    public void 로또_가격_생성() {
        assertThat(new LottoCount("3000", 1000)).isEqualTo(new LottoCount(3));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, true",
            "1, 2, false",
            "2, 1, true"
    })
    public void 대소비교(int count, int otherCount, boolean expected) {
        assertThat(new LottoCount(count).isBiggerOrSameThan(new LottoCount(otherCount))).isEqualTo(expected);
    }
}
