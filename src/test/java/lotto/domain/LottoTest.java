package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("통계 테스트")
    void findStatisticsTest() {
        Lotto winningLotto = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "6"));

        Lotto lotto = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "6"));

        assertThat(lotto.findMatchingBall(winningLotto))
                .isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 숫자 포함 테스트")
    void hasBonusNumberTest() {
        Lotto lotto = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "6"));
        LottoNumber bonusNumber = LottoNumber.createManualLottoNumber("1");

        assertThat(lotto.hasBonusNumber(bonusNumber))
                .isTrue();
    }

    @Test
    @DisplayName("보너스 숫자 미포함 테스트")
    void hasNoBonusNumberTest() {
        Lotto lotto = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "6"));
        LottoNumber bonusNumber = LottoNumber.createManualLottoNumber("7");

        assertThat(lotto.hasBonusNumber(bonusNumber))
                .isFalse();
    }

}