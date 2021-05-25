package kr.insup.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    Lotto lotto;
    LottoNumber bonusNumber;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = LottoNumber.of(7);
    }

    @DisplayName("WinningLotto 생성")
    @Test
    void WinningLotto_생성() {
        //when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        //then
        assertThat(winningLotto).isEqualTo(new WinningLotto(lotto, LottoNumber.of(7)));
    }

    @DisplayName("보너스 번호 유효성 검사")
    @Test
    void 보너스_번호_유효성_검사() {
        //when, then
        assertThatThrownBy(() -> new WinningLotto(lotto, LottoNumber.of(46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
