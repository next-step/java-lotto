package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @Test
    @DisplayName("보너스 넘버가 중복 될 경우 에러")
    void contains() {
        //given
        WinningNumber 당첨_번호 = new WinningNumber(Lotto.of(1, 2, 3, 4, 5, 6));
        LottoNumber 보너스_번호 = LottoNumber.of(1);
        //when
        boolean 포함_여부 = 당첨_번호.contains(보너스_번호);
        //then
        assertThat(포함_여부).isTrue();
    }
}