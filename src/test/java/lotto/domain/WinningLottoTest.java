package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("6개의 일반 번호와 1개의 보너스 번호로 이루어진다.")
    void containsSixNumbersAndOneBonusNumberTest() {
        //given
        WinningLotto winningLotto = new WinningLotto(
            IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()),
            new LottoNumber(7));

        //when, then
        assertThat(winningLotto.getLottoNumbers()).hasSize(6);
        assertThat(winningLotto.getBonus()).isInstanceOf(LottoNumber.class);
    }
}
