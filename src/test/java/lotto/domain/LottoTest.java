package lotto.domain;

import lotto.dto.WinningInfoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("당첨번호 포함 갯수에 따른 당첨정보 리턴")
    @Test
    void 당첨정보_리턴() {
        Lotto lotto = new Lotto("5, 2,21,45, 34,30");
        assertThat(lotto.winningInfo("1,2,3,45,5,6"))
                .usingRecursiveComparison()
                .isEqualTo(new WinningInfoDTO(3, new WinningAmount(5000)));
    }
}