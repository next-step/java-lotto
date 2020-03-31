package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoProvider;
import step2.domain.WinningLotto;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @Test
    @DisplayName("입력받은 보너스 번호가 로또 번호와 중복되지 않아야 함을 검증한다.")
    void validateWinningLotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        });
    }

    @Test
    @DisplayName("당첨 숫자 개수 체크가 제대로 되는지 테스트")
    void WinningNumber() {
        WinningLotto lotto = LottoProvider.createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5, 7)))).isEqualTo(5);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 7, 8)))).isEqualTo(4);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 7, 8, 9)))).isEqualTo(3);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 2, 7, 8, 9, 10)))).isEqualTo(2);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 7, 8, 9, 10, 11)))).isEqualTo(1);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(7, 8, 9, 10, 11, 12)))).isEqualTo(0);
    }
}
