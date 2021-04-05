package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Domain.InputNumber;
import step2.Domain.LottoNumber;
import step2.Domain.WinningLotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusBallTest {
    @Test
    @DisplayName("보너스 볼 생성 테스트 - 중복 테스트")
    void bonusBallTest() {
        assertThatThrownBy(() -> {
            InputNumber inputNumber = new InputNumber("1,2,3,4,5,7");
            LottoNumber bonusBall = new LottoNumber(5);
            WinningLotto winningLotto = new WinningLotto(inputNumber, bonusBall);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
