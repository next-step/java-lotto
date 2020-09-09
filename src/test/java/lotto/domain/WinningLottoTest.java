package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WinningLottoTest {

    @Test
    @DisplayName("우승 번호 생성 테스트")
    void create() {
        assertNotNull(WinningLotto.of(1, 2, 3, 4, 5, 6));
        assertNotNull(WinningLotto.of(40, 41, 42, 43, 44, 45));
    }

    @Test
    @DisplayName("우승 번호 유효성 검사")
    void create_validate() {
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.of(1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.of(0, 1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.of(1, 2, -3, 4, 5, 6));
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.of(41, 42, 43, 44, 45, 46));
    }

    @Test
    @DisplayName("일치하는 숫자 개수 확인")
    void matching() {
        // given
        WinningLotto winningNumbers = WinningLotto.of(1, 2, 3, 4, 5, 6);
        List<LottoNumbers> myNumbers = Arrays.asList(
                LottoNumbers.of(7, 8, 9, 10, 11, 12),
                LottoNumbers.of(1, 2, 9, 10, 11, 12),
                LottoNumbers.of(1, 2, 3, 7, 8, 9),
                LottoNumbers.of(1, 2, 3, 4, 8, 9),
                LottoNumbers.of(1, 2, 3, 4, 5, 9),
                LottoNumbers.of(1, 2, 3, 4, 5, 6)
        );

        // when
        LottoResult actual = winningNumbers.drawing(myNumbers);

        // then
        List<Prize> expected = Arrays.asList(
                Prize.ETC, Prize.ETC,
                Prize.FOURTH,
                Prize.THIRD,
                Prize.SECOND,
                Prize.FIRST
        );

        assertThat(actual).isEqualTo(new LottoResult(expected));
    }
}
