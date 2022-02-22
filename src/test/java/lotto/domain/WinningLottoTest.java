package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 당첨로또_생성() {
        // given
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::from)
            .collect(Collectors.toList()));
        LottoNumber bonusNumber = LottoNumber.from(3);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
