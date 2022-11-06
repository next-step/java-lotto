package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    void test_first() {
        assertThat(LottoResult.of(6, false)).isEqualTo(LottoResult.FIRST);
        assertThat(LottoResult.of(6, true)).isEqualTo(LottoResult.FIRST);
    }

    @Test
    void test_bonus() {
        assertThat(LottoResult.of(5, true)).isEqualTo(LottoResult.BONUS);
    }

    @Test
    void test_second() {
        assertThat(LottoResult.of(5, false)).isEqualTo(LottoResult.SECOND);
    }

    @Test
    void test_third() {
        assertThat(LottoResult.of(4, false)).isEqualTo(LottoResult.THIRD);
        assertThat(LottoResult.of(4, true)).isEqualTo(LottoResult.THIRD);
    }

    @Test
    void test_fourth() {
        assertThat(LottoResult.of(3, false)).isEqualTo(LottoResult.FOURTH);
        assertThat(LottoResult.of(3, true)).isEqualTo(LottoResult.FOURTH);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void test_none(int matchingCount) {
        assertThat(LottoResult.of(matchingCount, false)).isEqualTo(LottoResult.NONE);
        assertThat(LottoResult.of(matchingCount, true)).isEqualTo(LottoResult.NONE);
    }
}
