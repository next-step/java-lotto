package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinningCombo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningComboTest {
    Lotto winningLotto = Lotto.of(1, 2, 3, 4, 5, 6);

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void of(int duplicatesNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningCombo.of(winningLotto, LottoNumber.from(duplicatesNumber)))
                .withMessage("보너스 볼은 당첨 번호와 중복될 수 없습니다.");

        assertThatCode(() -> WinningCombo.of(winningLotto, LottoNumber.from(45)))
                .doesNotThrowAnyException();;
    }


    @Test
    void determinePrize() {
        // given
        LottoNumber bonusBall = LottoNumber.from(45);
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 45);

        WinningCombo winningCombo = WinningCombo.of(winningLotto, bonusBall);

        // when
        Rank rank = winningCombo.determinePrize(lotto);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
