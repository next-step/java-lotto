package lotto;

import lotto.domain.LottoPrize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 당첨번호가_3개_미만_보너스번호_불일치(int commonNumberCount) {
        assertThat(LottoPrize.find(commonNumberCount, false)).isEqualTo(Optional.empty());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 당첨번호가_3개_미만_보너스번호_일치(int commonNumberCount) {
        assertThat(LottoPrize.find(commonNumberCount, true)).isEqualTo(Optional.empty());
    }

    @Test
    void 당첨번호가_3개_보너스번호_불일치() {
        assertThat(LottoPrize.find(3, false)).isEqualTo(Optional.of(LottoPrize.FIFTH));
    }

    @Test
    void 당첨번호가_3개_보너스번호_일치() {
        assertThat(LottoPrize.find(3, true)).isEqualTo(Optional.of(LottoPrize.FIFTH));
    }

    @Test
    void 당첨번호가_4개_보너스번호_불일치() {
        assertThat(LottoPrize.find(4, false)).isEqualTo(Optional.of(LottoPrize.FORTH));
    }

    @Test
    void 당첨번호가_4개_보너스번호_일치() {
        assertThat(LottoPrize.find(4, true)).isEqualTo(Optional.of(LottoPrize.FORTH));
    }

    @Test
    void 당첨번호가_5개_보너스번호_불일치() {
        assertThat(LottoPrize.find(5, false)).isEqualTo(Optional.of(LottoPrize.THIRD));
    }

    @Test
    void 당첨번호가_5개_보너스번호_일치() {
        assertThat(LottoPrize.find(5, true)).isEqualTo(Optional.of(LottoPrize.SECOND));
    }


    @Test
    void 당첨번호가_6개_보너스번호_불일치() {
        assertThat(LottoPrize.find(6, false)).isEqualTo(Optional.of(LottoPrize.FIRST));
    }

    @Test
    void 당첨번호가_6개_보너스번호_일치() {
        assertThat(LottoPrize.find(6, true)).isEqualTo(Optional.of(LottoPrize.FIRST));
    }
}
