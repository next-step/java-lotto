package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.controller.LottoMachine;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    @DisplayName("숫자를 입력받아 생성한 Lotto가 1-45 사이의 숫자들인지, 중복되는 숫자는 없는지, 맞는 개수가 입력되었는 지 검증한다.")
    void validateLotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLotto(1, 2, 46, 3, 4, 5);
        }).withMessage("숫자들이 1과 45사이의 정수들로 이루어져야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLotto(1, 2, 3, 3, 4, 5);
        }).withMessage("중복되는 숫자를 가져서는 안됩니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.createLotto(1, 2, 3, 6, 4, 5, 7);
        }).withMessage("정해진 개수의 숫자를 입력해주세요.");
    }
}
