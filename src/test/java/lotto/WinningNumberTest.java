package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {
    @Test
    @DisplayName("당첨 확인 테스트")
    void checkWinning() {
        Lotto winningLotto = LottoGenerator.generateManualLotto(Arrays.asList(1,2,3,4,5,6));
        WinningNumber winningNumber = new WinningNumber(winningLotto, new LottoNumber(7));

        assertThat(
                winningNumber.checkWinning(winningLotto)
        ).isEqualTo(LottoRank.FIRST);

        assertThat(
                winningNumber.checkWinning(
                        LottoGenerator.generateManualLotto(Arrays.asList(10,2,3,4,5,6))
                )
        ).isEqualTo(LottoRank.THIRD);

        assertThat(
                winningNumber.checkWinning(
                        LottoGenerator.generateManualLotto(Arrays.asList(10,20,3,4,5,6))
                )
        ).isEqualTo(LottoRank.FOURTH);

        assertThat(
                winningNumber.checkWinning(
                        LottoGenerator.generateManualLotto(Arrays.asList(10,20,30,4,5,6))
                )
        ).isEqualTo(LottoRank.FIFTH);

        assertThat(
                winningNumber.checkWinning(
                        LottoGenerator.generateManualLotto(Arrays.asList(10,20,30,40,5,6))
                )
        ).isEqualTo(LottoRank.NONE);

        assertThat(
                winningNumber.checkWinning(
                        LottoGenerator.generateManualLotto(Arrays.asList(10,20,30,40,45,6))
                )
        ).isEqualTo(LottoRank.NONE);

        assertThat(
                winningNumber.checkWinning(
                        LottoGenerator.generateManualLotto(Arrays.asList(10,20,30,40,45,44))
                )
        ).isEqualTo(LottoRank.NONE);
    }

    @Test
    @DisplayName("2등 당첨 확인 테스트")
    void checkWinningSecond() {
        Lotto winningLotto = LottoGenerator.generateManualLotto(Arrays.asList(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);

        assertThat(
                winningNumber.checkWinning(
                        LottoGenerator.generateManualLotto(Arrays.asList(1,2,3,4,5,7))
                )
        ).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("보너스 번호와 일반 당첨 번호가 중복되면 오류를 내는지 테스트")
    void invalidBonusNumber() {
        Lotto winningLotto = LottoGenerator.generateManualLotto(Arrays.asList(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumber(winningLotto, bonusNumber);
        });
    }
}