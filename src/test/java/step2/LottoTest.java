package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.controller.LottoMachine;
import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.LottoProvider;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    private static LottoMachine lottoMachine = LottoMachine.getInstance();

    @Test
    @DisplayName("숫자를 입력받아 생성한 Lotto가 1-45 사이의 숫자들인지, 중복되는 숫자는 없는지, 맞는 개수가 입력되었는 지 검증한다.")
    void validateLotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createLotto(Arrays.asList(1, 2, 46, 3, 4, 5));
        }).withMessage(LottoNumber.LOTTO_NUMBER_RANGE_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createLotto(Arrays.asList(1, 2, 3, 3, 4, 5));
        }).withMessage(Lotto.LOTTO_NUMBER_DUPLICATION_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createLotto(Arrays.asList(1, 2, 3, 6, 4, 5, 7));
        }).withMessage(Lotto.LOTTO_NUMBER_COUNT_ERROR);
    }

    @Test
    @DisplayName("당첨 숫자 개수 체크가 제대로 되는지 테스트")
    void WinningNumber() {
        Lotto lotto = LottoMachine.getInstance().createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5, 7)))).isEqualTo(5);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 7, 8)))).isEqualTo(4);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 7, 8, 9)))).isEqualTo(3);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 2, 7, 8, 9, 10)))).isEqualTo(2);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(1, 7, 8, 9, 10, 11)))).isEqualTo(1);
        assertThat(lotto.getMatchedNumberCount(LottoProvider.createLotto(Arrays.asList(7, 8, 9, 10, 11, 12)))).isEqualTo(0);
    }
}
