package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.controller.LottoMachine;
import step2.domain.Lotto;
import step2.domain.LottoNumber;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    @DisplayName("숫자를 입력받아 생성한 Lotto가 1-45 사이의 숫자들인지, 중복되는 숫자는 없는지, 맞는 개수가 입력되었는 지 검증한다.")
    void validateLotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLotto(1, 2, 46, 3, 4, 5);
        }).withMessage(LottoNumber.LOTTO_NUMBER_RANGE_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLotto(1, 2, 3, 3, 4, 5);
        }).withMessage(Lotto.LOTTO_NUMBER_DUPLICATION_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLotto(1, 2, 3, 6, 4, 5, 7);
        }).withMessage(Lotto.LOTTO_NUMBER_COUNT_ERROR);
    }
}
