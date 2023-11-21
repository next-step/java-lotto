package lotto.domain;

import lotto.dto.WinningInfoDTO;
import lotto.dto.WinningNumbersDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("당첨번호 포함 갯수에 따른 당첨정보 리턴")
    @Test
    void 당첨정보_리턴() {
        Lotto lotto = new Lotto("2, 5,21,45, 34,30");
        Lotto winningLotto = new Lotto("1,2,3,5,6,45");
        LottoNumber lottoNumber = new LottoNumber("34");
        assertThat(lotto.winningInfo(new WinningNumbersDTO(winningLotto, lottoNumber)))
                .isEqualTo(new WinningInfoDTO(3, true ,new Amount(5_000)));
    }
}