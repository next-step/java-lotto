package lotto.domain.prize;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {
    String enteredWinNumber = "1, 2, 3, 4, 5, 6";

    @Test
    void 생성_테스트() {
        assertThatCode(() -> WinningLotto.create(enteredWinNumber, 10)).doesNotThrowAnyException();
    }

    @Test
    void 당첨번호와_보너스볼_중복확인() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> WinningLotto.create(enteredWinNumber, 6)
        ).withMessageContaining("보너스 볼이 당첨번호와 중복됩니다.");
    }

}
