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
    void 당첨번호가_3개_미만(int commonNumberCount) {
        assertThat(LottoPrize.findByCommonNumberCount(commonNumberCount)).isEqualTo(Optional.empty());
    }

    @Test
    void 당첨번호가_3개() {
        assertThat(LottoPrize.findByCommonNumberCount(3)).isEqualTo(Optional.of(LottoPrize.FORTH));
    }

    @Test
    void 당첨번호가_4개() {
        assertThat(LottoPrize.findByCommonNumberCount(4)).isEqualTo(Optional.of(LottoPrize.THIRD));
    }

    @Test
    void 당첨번호가_5개() {
        assertThat(LottoPrize.findByCommonNumberCount(5)).isEqualTo(Optional.of(LottoPrize.SECOND));
    }

    @Test
    void 당첨번호가_6개() {
        assertThat(LottoPrize.findByCommonNumberCount(6)).isEqualTo(Optional.of(LottoPrize.FIRST));
    }
}
