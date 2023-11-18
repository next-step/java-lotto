package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또정렬/숫자6개로생성/정렬된다.")
    void 숫자6개인_로또_정렬생성() {
        // given when
        Lotto lotto = Lotto.of(Arrays.asList(3, 6, 5, 4, 1, 2));
        // then
        assertThat(lotto.getLottoNums())
                .containsExactly(new LottoNum(1), new LottoNum(2), new LottoNum(3), new LottoNum(4), new LottoNum(5), new LottoNum(6));
    }

    @Test
    @DisplayName("로또생성실패/숫자7개로생성/IllegalArgumentException")
    void 숫자7개인_로또_생성실패() {
        // when then
        assertThatThrownBy(() -> Lotto.of(Arrays.asList(3, 6, 5, 4, 1, 2, 8))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또생성실패/중복된값/IllegalArgumentException")
    void 중복된_로또_생성실패() {
        // when then
        assertThatThrownBy(() -> Lotto.of(Arrays.asList(1, 1, 1, 1, 1, 1))).isInstanceOf(IllegalArgumentException.class);
    }
}
